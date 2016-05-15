/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import iib2_gruppe1.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Adresse;

/**
 *
 * @author Florian
 */
public class AdresseDao extends DbConnection {

    public List<Adresse> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Adresse> returnList = new ArrayList<Adresse>();
        String statement = "select * from adresse;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setAdrId(resultSet.getInt("adr_id"));
                adresse.setAdrStrasse(resultSet.getString("adr_strasse"));
                adresse.setAdrHausnummer(resultSet.getString("adr_hausnummer"));
                adresse.setAdrPlz(resultSet.getString("adr_plz"));
                adresse.setAdrOrt(resultSet.getString("adr_ort"));
                adresse.setAdrLand(resultSet.getString("adr_land"));
                returnList.add(adresse);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public List<Adresse> selectById(Adresse _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Adresse> returnList = new ArrayList<Adresse>();
        String statement = "select * from adresse where adr_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getAdrId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setAdrId(resultSet.getInt("adr_id"));
                adresse.setAdrStrasse(resultSet.getString("adr_strasse"));
                adresse.setAdrHausnummer(resultSet.getString("adr_hausnummer"));
                adresse.setAdrPlz(resultSet.getString("adr_plz"));
                adresse.setAdrOrt(resultSet.getString("adr_ort"));
                adresse.setAdrLand(resultSet.getString("adr_land"));
                returnList.add(adresse);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public int insert(Adresse _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into adresse (adr_strasse, adr_hausnummer, adr_plz, adr_ort, adr_land) values(?, ?, ?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getAdrStrasse());
            preparedStatement.setString(2, _bean.getAdrHausnummer());
            preparedStatement.setString(3, _bean.getAdrPlz());
            preparedStatement.setString(4, _bean.getAdrOrt());
            preparedStatement.setString(5, _bean.getAdrLand());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Adresse _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update adresse set adr_strasse = ?, adr_hausnummer = ?, adr_plz = ?, adr_ort = ?, adr_land = ? where adr_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getAdrStrasse());
            preparedStatement.setString(2, _bean.getAdrHausnummer());
            preparedStatement.setString(3, _bean.getAdrPlz());
            preparedStatement.setString(4, _bean.getAdrOrt());
            preparedStatement.setString(5, _bean.getAdrLand());
            preparedStatement.setInt(6, _bean.getAdrId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Adresse _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from adresse where adr_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getAdrId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
