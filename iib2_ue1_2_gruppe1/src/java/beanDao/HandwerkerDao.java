/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Adresse;
import bean.Handwerker;
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
public class HandwerkerDao extends DbConnection {

    public List<Handwerker> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Handwerker> returnList = new ArrayList<Handwerker>();
        String statement = "select * from handwerker;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Handwerker handwerker = new Handwerker();
                HandwerkerDao a = new HandwerkerDao();
                handwerker.setHawEmail(resultSet.getString("haw_email"));
                handwerker.setHawVorname(resultSet.getString("haw_vorname"));
                handwerker.setHawNachname(resultSet.getString("haw_nachname"));
                Adresse tmp = new Adresse();
                tmp.setAdrId(resultSet.getInt("haw_adr_id"));
                handwerker.setAdresse(new AdresseDao().selectById(tmp).get(0));
                handwerker.setHawPasswort(resultSet.getString("haw_passwort"));
                returnList.add(handwerker);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public List<Handwerker> selectByEmail(Handwerker _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Handwerker> returnList = new ArrayList<Handwerker>();
        String statement = "select * from handwerker where haw_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getHawEmail());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Handwerker handwerker = new Handwerker();
                HandwerkerDao a = new HandwerkerDao();
                handwerker.setHawEmail(resultSet.getString("haw_email"));
                handwerker.setHawVorname(resultSet.getString("haw_vorname"));
                handwerker.setHawNachname(resultSet.getString("haw_nachname"));
                Adresse tmp = new Adresse();
                tmp.setAdrId(resultSet.getInt("haw_adr_id"));
                handwerker.setAdresse(new AdresseDao().selectById(tmp).get(0));
                handwerker.setHawPasswort(resultSet.getString("haw_passwort"));
                returnList.add(handwerker);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }

    public int insert(Handwerker _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into handwerker (haw_email, haw_vornmae, haw_nachname, haw_adr_id, haw_passwort) values(?, ?, ?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getHawEmail());
            preparedStatement.setString(2, _bean.getHawVorname());
            preparedStatement.setString(3, _bean.getHawNachname());
            preparedStatement.setInt(5, _bean.getAdresse().getAdrId());
            preparedStatement.setString(6, _bean.getHawPasswort());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Handwerker _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update handwerker set haw_email = ?, haw_vorname = ?, haw_nachname = ?, haw_adr_id = ? where haw_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getHawEmail());
            preparedStatement.setString(2, _bean.getHawVorname());
            preparedStatement.setString(3, _bean.getHawNachname());
            preparedStatement.setInt(4, _bean.getAdresse().getAdrId());
            preparedStatement.setString(5, _bean.getHawEmail());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Handwerker _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from handwerker where haw_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getHawEmail());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
