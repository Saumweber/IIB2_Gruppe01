/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlBeanDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Florian
 */
public class AuftragDao extends Dao {

    public int iAuftrag(Object _bean) {
        PreparedStatement preparedStatement = null;
        int resultSet = -1;
        Map statement = this.insert(_bean);

        boolean autoCommit = true;
        try {
            autoCommit = this.connection.getAutoCommit();
            this.connection.setAutoCommit(false);

            Iterator<Map.Entry<String, Map>> iteratorStatement = statement.entrySet().iterator();
            while (iteratorStatement.hasNext()) {
                Map.Entry<String, Map> entryStatement = iteratorStatement.next();

                preparedStatement = this.connection.prepareStatement(entryStatement.getKey());
                Iterator<Map.Entry<String, Object>> iteratorValue = entryStatement.getValue().entrySet().iterator();
                int i = 0;
                while (iteratorValue.hasNext()) {
                    preparedStatement.setObject(++i, entryStatement.getValue());
                }
                resultSet = preparedStatement.executeUpdate();
                
                if (resultSet < 0) {
                    this.connection.rollback();
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            try {
                this.connection.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
            return resultSet;
        }
    }
}
