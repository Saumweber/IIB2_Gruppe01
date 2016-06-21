/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import bean.Nutzer;
import bean.Sanierungsauftrag;
import bean.Lnsiehtan;
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
public class LnSiehtAnDao extends DbConnection {
   
    public List<Lnsiehtan> select() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Lnsiehtan> returnList = new ArrayList<Lnsiehtan>();
        String statement = "select * from lnsiehtan;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Lnsiehtan lnsiehtan = new Lnsiehtan();
                lnsiehtan.setLnsId(resultSet.getInt("lns_id"));
                Nutzer tmpntz = new Nutzer();
                tmpntz.setNtzEmail(resultSet.getString("Nutzer_ntz_email"));
                lnsiehtan.setNutzer(new NutzerDao().selectByEmail(tmpntz).get(0));
                Sanierungsauftrag tmpsnr = new Sanierungsauftrag();
                tmpsnr.setSnrId(resultSet.getInt("Sanierungsauftrag_snr_id"));
                lnsiehtan.setSanierungsauftrag(new SanierungsauftragDao().selectById(tmpsnr).get(0));
                returnList.add(lnsiehtan);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public List<Lnsiehtan> selectById(Lnsiehtan _bean) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Lnsiehtan> returnList = new ArrayList<Lnsiehtan>();
        String statement = "select * from lnsiehtan where haw_email = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getLnsId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Lnsiehtan lnsiehtan = new Lnsiehtan();
                lnsiehtan.setLnsId(resultSet.getInt("lns_id"));
                Nutzer tmpntz = new Nutzer();
                tmpntz.setNtzEmail(resultSet.getString("Nutzer_ntz_email"));
                lnsiehtan.setNutzer(new NutzerDao().selectByEmail(tmpntz).get(0));
                Sanierungsauftrag tmpsnr = new Sanierungsauftrag();
                tmpsnr.setSnrId(resultSet.getInt("Sanierungsauftrag_snr_id"));
                lnsiehtan.setSanierungsauftrag(new SanierungsauftragDao().selectById(tmpsnr).get(0));
                returnList.add(lnsiehtan);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return returnList;
    }
    
    public int insert(Lnsiehtan _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "insert into lnsiehtan (lns_id, Nutzer_ntz_email, Sanierungsauftrag_snr_id) values(?, ?, ?);";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getLnsId());
            preparedStatement.setString(2, _bean.getNutzer().getNtzEmail());
            preparedStatement.setInt(3, _bean.getSanierungsauftrag().getSnrId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int update(Lnsiehtan _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "update lnsiehtan set lns_id = ?, Nutzer_ntz_email = ?, Sanierungsauftrag_snr_id = ? where lns_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getLnsId());
            preparedStatement.setString(2, _bean.getNutzer().getNtzEmail());
            preparedStatement.setInt(3, _bean.getSanierungsauftrag().getSnrId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }

    public int delete(Lnsiehtan _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        String statement = "delete from lnsiehtan where lns_id = ?;";

        try {
            preparedStatement = this.connection.prepareStatement(statement);
            preparedStatement.setInt(1, _bean.getLnsId());
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return resultSet;
    }
   
}
