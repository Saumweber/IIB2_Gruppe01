/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Adresse;
import bean.Eigentuemer;
import iib2_gruppe1.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class EigentuemerDao extends DbConnection {

    public List<Eigentuemer> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Eigentuemer> returnList = new ArrayList<Eigentuemer>();
        String statement = "select * from eigentuemer;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Eigentuemer eigentuemer = new Eigentuemer();
                EigentuemerDao a = new EigentuemerDao();
                eigentuemer.setEigEmail(resultSet.getString("eig_email"));
                eigentuemer.setEigVorname(resultSet.getString("eig_vorname"));
                eigentuemer.setEigNachname(resultSet.getString("eig_nachname"));
                eigentuemer.setEigKunde(resultSet.getBoolean("eig_kunde"));  
                Adresse tmp = new Adresse();
                tmp.setAdrId(resultSet.getInt("eig_adr_id"));
                eigentuemer.setAdresse(new AdresseDao().selectById(tmp).get(0));
                eigentuemer.setEigPasswort(resultSet.getString("eig_passwort"));
                returnList.add(eigentuemer);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public List<Eigentuemer> selectByEmail(Eigentuemer _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Eigentuemer> returnList = new ArrayList<Eigentuemer>();
        String statement = "select * from eigentuemer where eig_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getEigEmail());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Eigentuemer eigentuemer = new Eigentuemer();
                EigentuemerDao a = new EigentuemerDao();
                eigentuemer.setEigEmail(resultSet.getString("eig_email"));
                eigentuemer.setEigVorname(resultSet.getString("eig_vorname"));
                eigentuemer.setEigNachname(resultSet.getString("eig_nachname"));
                eigentuemer.setEigKunde(resultSet.getBoolean("eig_kunde"));  
                Adresse tmp = new Adresse();
                tmp.setAdrId(resultSet.getInt("eig_adr_id"));
                eigentuemer.setAdresse(new AdresseDao().selectById(tmp).get(0));
                eigentuemer.setEigPasswort(resultSet.getString("eig_passwort"));
                returnList.add(eigentuemer);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public int insert(Eigentuemer _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into eigentuemer (eig_email, eig_vornmae, eig_nachname, eig_kunde, eig_adr_id, eig_passwort) values(?, ?, ?, ?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getEigEmail());
            preparedStatement.setString(2, _bean.getEigVorname());
            preparedStatement.setString(3, _bean.getEigNachname());
            preparedStatement.setBoolean(4, _bean.getEigKunde());
            preparedStatement.setInt(5, _bean.getAdresse().getAdrId());
            preparedStatement.setString(6, _bean.getEigPasswort());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Eigentuemer _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update eigentuemer set eig_email = ?, eig_vorname = ?, eig_nachname = ?, eig_kunde = ?, eig_adr_id = ? where eig_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getEigEmail());
            preparedStatement.setString(2, _bean.getEigVorname());
            preparedStatement.setString(3, _bean.getEigNachname());
            preparedStatement.setBoolean(4, _bean.getEigKunde());
            preparedStatement.setInt(5, _bean.getAdresse().getAdrId());
            preparedStatement.setString(6, _bean.getEigEmail());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Eigentuemer _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from eigentuemer where eig_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getEigEmail());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
