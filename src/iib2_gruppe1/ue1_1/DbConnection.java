/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iib2_gruppe1.ue1_1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Florian
 */
public final class DbConnection extends iib2_gruppe1.DbConnection {

    /**
     *
     * @desc Fügt der Relation Adresse ein neues Tupel hinzu.
     * @param _strasse Straße der Adresse.
     * @param _hausnummer Hausnummer zur Adresse.
     * @param _plz Postleitzahl der Adresse.
     * @param _ort Ort der Adresse.
     * @param _land Land der Adresse.
     * @param _kunde_id Kunden, dem die Adresse zugeordnet wird.
     * @return Ein Integer. Ist dieser <0, so wurde der Insert abgebrochen.
     * Ist dieser =0, so wurde das Statement ausgeführt, aber keine Datensätze
     * manipuliert. Ist dieser >0, so wurden demenstrpechend viele Datensätze
     * manipuliert, um über dieses iterieren zu können.
     */
    public int iAdresse(String _strasse, String _hausnummer, String _plz, String _ort, String _land, int _kunde_id) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into adresse (strasse, hausnummer, plz, ort, land, kunde_id) values(?, ?, ?, ?, ?, ?);";

        String msg = "";
        _strasse = _strasse.trim();
        _hausnummer = _hausnummer.trim();
        _plz = _plz.trim();
        _ort = _ort.trim();
        _land = _land.trim();
        if (_strasse.isEmpty() || _strasse.length() < 4) {
            msg = msg + "Strasse ist leer bzw. zu kurz.\n";
        }
        if (_hausnummer.isEmpty() || Integer.valueOf(_hausnummer) < 0) {
            msg = msg + "Hausnummer ist leer bzw. negativ.\n";
        }
        if (_plz.isEmpty() || _plz.length() < 3) {
            msg = msg + "PLZ ist leer bzw. zu kurz.\n";
        }
        if (_ort.isEmpty() || _ort.length() < 1) {
            msg = msg + "Ort ist leer bzw. zu kurz.\n";
        }
        if (_land.isEmpty() || _land.length() < 1) {
            msg = msg + "Land ist leer bzw. zu kurz.\n";
        }
        try {
            if (_kunde_id < 0 || !this.sKunde(_kunde_id).first()) {
                msg = msg + "Kunden_Id nicht gefunden.\n";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        if (!msg.isEmpty()) {
            System.out.print(msg);
            return resultSet;
        }

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _strasse);
            preparedStatement.setString(2, _hausnummer);
            preparedStatement.setString(3, _plz);
            preparedStatement.setString(4, _ort);
            preparedStatement.setString(5, _land);
            preparedStatement.setInt(6, _kunde_id);
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Fügt der Relation Kunden ein neues Tupel hinzu.
     * @param _name Straße der Adresse.
     * @param _vorname Hausnummer zur Adresse.
     * @return Ein Integer. Ist dieser <0, so wurde der Insert abgebrochen.
     * Ist dieser =0, so wurde das Statement ausgeführt, aber keine Datensätze
     * manipuliert. Ist dieser >0, so wurden demenstrpechend viele Datensätze
     * manipuliert, um über dieses iterieren zu können.
     */
    public int iKunde(String _name, String _vorname) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into kunde (name, vorname) values(?, ?);";

        String msg = "";
        _name = _name.trim();
        _vorname = _vorname.trim();
        if (_name.isEmpty() || _name.length() < 2) {
            msg = msg + "Name ist leer bzw. zu kurz.\n";
        }
        if (_vorname.isEmpty() || _vorname.length() < 2) {
            msg = msg + "Vorname ist leer bzw. zu kurz.\n";
        }

        if (!msg.isEmpty()) {
            System.out.print(msg);
            return resultSet;
        }

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _name);
            preparedStatement.setString(2, _vorname);
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Fügt der Relation Auftrag ein neues Tupel hinzu.
     * @param _beschreibung Der Text, der im Auftrag enthalten ist.
     * @param _kunde_id Der Primärschlüssel des Kunden, der den Auftrag
     * veranlasste.
     * @return Ein Integer. Ist dieser <0, so wurde der Insert abgebrochen. Ist
     * dieser =0, so wurde das Statement ausgeführt, aber keine Datensätze
     * manipuliert. Ist dieser >0, so wurden demenstrpechend viele Datensätze
     * manipuliert, um über dieses iterieren zu können.
     */
    public int iAuftrag(String _beschreibung, int _kunde_id) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into auftrag (beschreibung, erledigt, kunde_id) values (?, ?, ?);";

        String msg = "";
        _beschreibung = _beschreibung.trim();
        if (_beschreibung.isEmpty() || _beschreibung.length() < 4) {
            msg = msg + "Beschreibung ist leer bzw. zu kurz.\n";
        }
        try {
            if (_kunde_id < 0 || !this.sKunde(_kunde_id).first()) {
                msg = msg + "Kunden_Id nicht gefunden.\n";
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        if (!msg.isEmpty()) {
            System.out.print(msg);
            return resultSet;
        }

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _beschreibung);
            preparedStatement.setBoolean(2, false);
            preparedStatement.setInt(3, _kunde_id);
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Gibt die gefundenen Adressen zurück.
     * @return Das ResultSet, um über dessen Adressen iterieren zu können.
     */
    public ResultSet sAdresse() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "select * from adresse;";
        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Gibt die gefundenen Adressen zurück.
     * @param _id Der Primärschlüssel des Adresstupels oder der des Kunden.
     * @param _idIsPrimaryKey Soll _id als Primärschlüssel interpretiert werden?
     * Falls nein, dann wird _id als kunde_id interpretiert.
     * @return Das ResultSet, um über dessen Adressen iterieren zu können.
     */
    public ResultSet sAdresse(int _id, boolean _idIsPrimaryKey) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "";
        if (_idIsPrimaryKey) {
            statement = "select * from adresse where id = ?;";
        } else {
            statement = "select * from adresse where kunde_id = ?;";
        }
        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Gibt die gefundenen Kunden zurück.
     * @return Das ResultSet, um über dessen Kunden iterieren zu können.
     */
    public ResultSet sKunde() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "select * from kunde;";
        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Gibt die gefundenen Kunden zurück.
     * @param _id Der Primärschlüssel des Kundentupels.
     * @return Das ResultSet, um über dessen Kunden iterieren zu können.
     */
    public ResultSet sKunde(int _id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "select * from kunde where id = ?;";
        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Gibt die gefundenen Aufträge zurück.
     * @return Das ResultSet, um über dessen Aufträge iterieren zu können.
     */
    public ResultSet sAuftrag() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "select * from auftrag;";
        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     *
     * @desc Gibt die gefundenen Aufträge zurück.
     * @param _id Der Primärschlüssel des Auftragtupels oder der des Kunden.
     * @param _idIsPrimaryKey Soll _id als Primärschlüssel interpretiert werden?
     * Falls nein, dann wird _id als kunde_id interpretiert.
     * @return Das ResultSet, um über dessen Aufträge iterieren zu können.
     */
    public ResultSet sAuftrag(int _id, boolean _idIsPrimaryKey) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String statement = "";
        if (_idIsPrimaryKey) {
            statement = "select * from auftrag where id = ?;";
        } else {
            statement = "select * from auftrag where kunde_id = ?;";
        }
        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
