/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Beruf;
import bean.Nutzer;
import iib2_gruppe1.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Benjamin
 */
public class NutzerDao extends DbConnection{
    
    //Attribute in Datenbank: ntz_email, ntz_passwort, ntz_name, ntz_vorname, Beruf_brf_id
    public List<Nutzer> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Nutzer> returnList = new ArrayList<Nutzer>();
        String statement = "select * from nutzer;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Nutzer nutzer = new Nutzer ();
                nutzer.setNtzEmail(resultSet.getString("ntz_email"));
                nutzer.setNtzPasswort(resultSet.getString("ntz_passwort"));
                nutzer.setNtzName(resultSet.getString("ntz_name"));
                nutzer.setNtzVorname(resultSet.getString("ntz_vorname"));
                Beruf tmp = new Beruf();
                tmp.setBrfId(resultSet.getInt("Beruf_brf_id"));
                nutzer.setBeruf(new BerufDao().selectById(tmp).get(0));
                returnList.add(nutzer);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Nutzer> selectByEmail(Nutzer _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Nutzer> returnList = new ArrayList<Nutzer>();
        String statement = "select * from nutzer where ntz_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getNtzEmail());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Nutzer nutzer = new Nutzer ();
                nutzer.setNtzEmail(resultSet.getString("ntz_email"));
                nutzer.setNtzPasswort(resultSet.getString("ntz_passwort"));
                nutzer.setNtzName(resultSet.getString("ntz_name"));
                nutzer.setNtzVorname(resultSet.getString("ntz_vorname"));
                Beruf tmp = new Beruf();
                tmp.setBrfId(resultSet.getInt("Beruf_brf_id"));
                nutzer.setBeruf(new BerufDao().selectById(tmp).get(0));
                returnList.add(nutzer);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Nutzer> selectByBeruf(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Nutzer> returnList = new ArrayList<Nutzer>();
        String statement = "select * from nutzer where Beruf_brf_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getBrfId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Nutzer nutzer = new Nutzer ();
                nutzer.setNtzEmail(resultSet.getString("ntz_email"));
                nutzer.setNtzPasswort(resultSet.getString("ntz_passwort"));
                nutzer.setNtzName(resultSet.getString("ntz_name"));
                nutzer.setNtzVorname(resultSet.getString("ntz_vorname"));
                Beruf tmp = new Beruf();
                tmp.setBrfId(resultSet.getInt("Beruf_brf_id"));
                nutzer.setBeruf(new BerufDao().selectById(tmp).get(0));
                returnList.add(nutzer);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
  
    public int insert(Nutzer _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into nutzer (ntz_email, ntz_passwort, ntz_name, ntz_vorname, Beruf_brf_id) values(?, ?, ?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getNtzEmail());
            preparedStatement.setString(2, _bean.getNtzPasswort());
            preparedStatement.setString(3, _bean.getNtzName());
            preparedStatement.setString(4, _bean.getNtzVorname());
            preparedStatement.setInt(5, _bean.getBeruf().getBrfId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Nutzer _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update nutzer set ntz_email = ?, ntz_passwort = ?, ntz_name = ?, ntz_vorname = ?, Beruf_brf_id = ? where ntz_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getNtzEmail());
            preparedStatement.setString(2, _bean.getNtzPasswort());
            preparedStatement.setString(3, _bean.getNtzName());
            preparedStatement.setString(4, _bean.getNtzVorname());
            preparedStatement.setInt(5, _bean.getBeruf().getBrfId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Nutzer _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from nutzer where ntz_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getNtzEmail());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
    
}
