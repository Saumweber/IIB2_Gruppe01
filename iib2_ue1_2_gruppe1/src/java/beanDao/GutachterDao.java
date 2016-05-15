/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Adresse;
import bean.Gutachter;
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
public class GutachterDao extends DbConnection {

    public List<Gutachter> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gutachter> returnList = new ArrayList<Gutachter>();
        String statement = "select * from gutachter;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Gutachter gutachter = new Gutachter();
                AdresseDao a = new AdresseDao();
                gutachter.setGutEmail(resultSet.getString("gut_email"));
                gutachter.setGutVorname(resultSet.getString("gut_vorname"));
                gutachter.setGutNachname(resultSet.getString("gut_nachname")); 
                Adresse tmp = new Adresse();
                tmp.setAdrId(resultSet.getInt("gut_adr_id"));
                gutachter.setAdresse(new AdresseDao().selectById(tmp).get(0));
                gutachter.setGutPasswort(resultSet.getString("gut_passwort"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public List<Gutachter> selectByEmail(Gutachter _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Gutachter> returnList = new ArrayList<Gutachter>();
        String statement = "select * from gutachter where gut_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getGutEmail());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Gutachter gutachter = new Gutachter();
                AdresseDao a = new AdresseDao();
                gutachter.setGutEmail(resultSet.getString("gut_email"));
                gutachter.setGutVorname(resultSet.getString("gut_vorname"));
                gutachter.setGutNachname(resultSet.getString("gut_nachname"));
                Adresse tmp = new Adresse();
                tmp.setAdrId(resultSet.getInt("gut_adr_id"));
                gutachter.setAdresse(new AdresseDao().selectById(tmp).get(0));
                gutachter.setGutPasswort(resultSet.getString("gut_passwort"));
                returnList.add(gutachter);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public int insert(Gutachter _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into gutachter (gut_email, gut_vornmae, gut_nachname, gut_adr_id, gut_passwort) values(?, ?, ?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getGutEmail());
            preparedStatement.setString(2, _bean.getGutVorname());
            preparedStatement.setString(3, _bean.getGutNachname());
            preparedStatement.setInt(5, _bean.getAdresse().getAdrId());
            preparedStatement.setString(6, _bean.getGutPasswort());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
