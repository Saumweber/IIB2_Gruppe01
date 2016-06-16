/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import iib2_gruppe1.DbConnection;
import bean.Beruf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
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
                beruf.setBerId(resultSet.getInt("ber_id"));
                beruf.setBerName(resultSet.getString("ber_name"));
                beruf.setBerSpezialisierung(resultSet.getString("ber_spezialisierung"));
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
        String statement = "select * from beruf where ber_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getBerId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Beruf beruf = new Beruf();
                beruf.setBerId(resultSet.getInt("adr_id"));
                beruf.setBerName(resultSet.getString("ber_name"));
                beruf.setBerSpezialisierung(resultSet.getString("ber_spezialisierung"));
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
        String statement = "insert into beruf (ber_name, ber_spezialisierung) values(?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getBerName());
            preparedStatement.setString(2, _bean.getBerSpezialisierung());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update beruf set ber_name = ?, ber_spezialisierung = ? where ber_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getBerName());
            preparedStatement.setString(2, _bean.getBerSpezialisierung());
            preparedStatement.setInt(3, _bean.getBerId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Beruf _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from beruf where ber_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getBerId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
}
