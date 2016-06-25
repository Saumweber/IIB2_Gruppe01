/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Sanierungsauftrag;
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
public class SanierungsauftragDao extends DbConnection{
    
    public List<Sanierungsauftrag> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sanierungsauftrag> returnList = new ArrayList<Sanierungsauftrag>();
        String statement = "select * from sanierungsauftrag;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sanierungsauftrag snrauftrag = new Sanierungsauftrag();
                snrauftrag.setSnrId(resultSet.getInt("snr_id"));
                snrauftrag.setSnrIfcpfad(resultSet.getString("snr_ifcpfad"));
                snrauftrag.setSnrGebaeude(resultSet.getString("snr_gebaeude"));
                snrauftrag.setSnrStatus(resultSet.getString("snr_status"));
                snrauftrag.setSnrBeschreibung(resultSet.getString("snr_beschreibung"));
                returnList.add(snrauftrag);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Sanierungsauftrag> selectById(Sanierungsauftrag _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sanierungsauftrag> returnList = new ArrayList<Sanierungsauftrag>();
        String statement = "select * from sanierungsauftrag where snr_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getSnrId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sanierungsauftrag snrauftrag = new Sanierungsauftrag();
                snrauftrag.setSnrId(resultSet.getInt("snr_id"));
                snrauftrag.setSnrIfcpfad(resultSet.getString("snr_ifcpfad"));
                snrauftrag.setSnrGebaeude(resultSet.getString("snr_gebaeude"));
                snrauftrag.setSnrStatus(resultSet.getString("snr_status"));
                snrauftrag.setSnrBeschreibung(resultSet.getString("snr_beschreibung"));
                returnList.add(snrauftrag);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Sanierungsauftrag> selectByGebaeude(Sanierungsauftrag _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sanierungsauftrag> returnList = new ArrayList<Sanierungsauftrag>();
        String statement = "select * from sanierungsauftrag where snr_gebaeude = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getSnrGebaeude());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sanierungsauftrag snrauftrag = new Sanierungsauftrag();
                snrauftrag.setSnrId(resultSet.getInt("snr_id"));
                snrauftrag.setSnrIfcpfad(resultSet.getString("snr_ifcpfad"));
                snrauftrag.setSnrGebaeude(resultSet.getString("snr_gebaeude"));
                snrauftrag.setSnrStatus(resultSet.getString("snr_status"));
                snrauftrag.setSnrBeschreibung(resultSet.getString("snr_beschreibung"));
                returnList.add(snrauftrag);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Sanierungsauftrag> selectByNutzer(Nutzer _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Sanierungsauftrag> returnList = new ArrayList<Sanierungsauftrag>();
        String statement = "select Sanierungsauftrag.* from sanierungsauftrag, lnsiehtan, nutzer "
                + "where ntz_email = Nutzer_ntz_email AND Sanierungsauftrag_snr_id = snr_id AND ntz_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setString(1, _bean.getNtzEmail());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sanierungsauftrag snrauftrag = new Sanierungsauftrag();
                snrauftrag.setSnrId(resultSet.getInt("snr_id"));
                snrauftrag.setSnrIfcpfad(resultSet.getString("snr_ifcpfad"));
                snrauftrag.setSnrGebaeude(resultSet.getString("snr_gebaeude"));
                snrauftrag.setSnrStatus(resultSet.getString("snr_status"));
                snrauftrag.setSnrBeschreibung(resultSet.getString("snr_beschreibung"));
                returnList.add(snrauftrag);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public int insert(Sanierungsauftrag _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into sanierungsauftrag (snr_id, snr_ifcpfad, snr_gebaeude, snr_status, snr_beschreibung) values(?, ?, ?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getSnrId());
            preparedStatement.setString(2, _bean.getSnrIfcpfad());
            preparedStatement.setString(3, _bean.getSnrGebaeude());
            preparedStatement.setString(4, _bean.getSnrStatus());
            preparedStatement.setString(5, _bean.getSnrBeschreibung());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Sanierungsauftrag _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update sanierungsauftrag set snr_id = ?, snr_ifcpfad = ?, snr_gebaeude = ?, snr_status = ?, snr_beschreibung = ? where snr_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getSnrId());
            preparedStatement.setString(2, _bean.getSnrIfcpfad());
            preparedStatement.setString(3, _bean.getSnrGebaeude());
            preparedStatement.setString(4, _bean.getSnrStatus());
            preparedStatement.setString(5, _bean.getSnrBeschreibung());
            preparedStatement.setInt(6, _bean.getSnrId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
   
    public int delete(Sanierungsauftrag _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from sanierungsauftrag where snr_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getSnrId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
    
}
