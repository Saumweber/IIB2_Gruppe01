/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Beruf;
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
public class BerufDao extends DbConnection {
    
    public List<Beruf> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Beruf> returnList = new ArrayList<Beruf>();
        String statement = "select * from beruf;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Beruf beruf = new Beruf();
                beruf.setBrfId(resultSet.getInt("brf_id"));
                beruf.setBrfBerufname(resultSet.getString("brf_berufname"));
                beruf.setBrfSpezialisierung(resultSet.getString("brf_spezialisierung"));
                returnList.add(beruf);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Beruf> selectWithoutBauplaner() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Beruf> returnList = new ArrayList<Beruf>();
        String statement = "select * from beruf where brf_berufname <> 'Bauplaner';";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Beruf beruf = new Beruf();
                beruf.setBrfId(resultSet.getInt("brf_id"));
                beruf.setBrfBerufname(resultSet.getString("brf_berufname"));
                beruf.setBrfSpezialisierung(resultSet.getString("brf_spezialisierung"));
                returnList.add(beruf);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Beruf> selectById(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Beruf> returnList = new ArrayList<Beruf>();
        String statement = "select * from beruf where brf_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getBrfId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Beruf beruf = new Beruf();
                beruf.setBrfId(resultSet.getInt("brf_id"));
                beruf.setBrfBerufname(resultSet.getString("brf_berufname"));
                beruf.setBrfSpezialisierung(resultSet.getString("brf_spezialisierung"));
                returnList.add(beruf);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Beruf> selectByBerufname(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Beruf> returnList = new ArrayList<Beruf>();
        String statement = "select * from beruf where brf_berufname = ? and brf_spezialisierung = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getBrfBerufname());
            preparedStatement.setString(2, _bean.getBrfSpezialisierung());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Beruf beruf = new Beruf();
                beruf.setBrfId(resultSet.getInt("brf_id"));
                beruf.setBrfBerufname(resultSet.getString("brf_berufname"));
                beruf.setBrfSpezialisierung(resultSet.getString("brf_spezialisierung"));
                returnList.add(beruf);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public int insert(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into beruf (brf_berufname, brf_spezialisierung) values(?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getBrfBerufname());
            preparedStatement.setString(2, _bean.getBrfSpezialisierung());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update beruf set ber_name = ?, ber_spezialisierung = ? where brf_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getBrfBerufname());
            preparedStatement.setString(2, _bean.getBrfSpezialisierung());
            preparedStatement.setInt(3, _bean.getBrfId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from beruf where brf_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getBrfId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
