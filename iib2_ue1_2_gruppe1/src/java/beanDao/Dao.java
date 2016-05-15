/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanDao;

import iib2_gruppe1.DbConnection;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Florian
 */
public abstract class Dao extends DbConnection {

    protected Map insert(Object _bean) {
        Map returnMap = new HashMap<String, Map>();
        String table = _bean.getClass().getSimpleName();
        String column = "";
        String value = "";
        Map properties = this.inspect(_bean);

        Iterator<Map.Entry<String, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (column.isEmpty()) {
                column = pair.getKey();
                value = "?";
            } else {
                column = column + ", " + pair.getKey();
                value = value + ", ?";
            }
        }
        String statement = "insert into " + table + " (" + column + ") values(" + value + ");";

        returnMap.put(statement, properties);
        return returnMap;
    }

    private Map inspect(Object _bean) {
        Map returnMap = new HashMap<String, Object>();

        Field[] fields = _bean.getClass().getDeclaredFields();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(_bean.getClass());
            for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
                String propertyName = propertyDesc.getName();
                Object value = propertyDesc.getReadMethod().invoke(_bean);
                returnMap.put(propertyName, value);
            }
            if (returnMap.size() > 0) {
                returnMap.remove(returnMap.size() - 1);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return returnMap;
    }
}
