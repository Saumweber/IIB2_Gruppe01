package iib2_gruppe1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Florian Saumweber: 2354534
 * @author Benjamin Krauß: 2388173
 */
public class DbConnection {

    public static Connection connection;
    private DbConnection dbConnection;
    private final String driverName;
    private final String serverName;
    private final String portNumber;
    private final String database;
    private final String uri;
    private final String username;
    private final String password;

    public DbConnection() {
        this.connection = null;
        this.driverName = "com.mysql.jdbc.Driver";
        this.serverName = "localhost";
        this.portNumber = "3306";
        this.database = "iib2_gruppe1";
        this.uri = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + database;
        this.username = "gruppe1";
        this.password = "iib2";

        this.connect();
    }

    /**
     * @desc Stellt die Verbindung zur Datenbank her. Dabei wir auf die in der
     * Klasse hinterlegten Daten (Server, Port, User, Datenbank) zugegriffen.
     */
    private void connect() {
        try {
            Class.forName(driverName);
            this.connection = DriverManager.getConnection(uri, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * @desc Falls bereits eine Datenbankverbindung besteht, wird diese
     * verwendet. Ansonsten eine neue erstellt.
     * @return Eine aktive Verbindung zur Datenbank.
     */
    public DbConnection getConnection() {
        if (this.dbConnection == null) {
            this.dbConnection = new DbConnection();
        }
        return this.dbConnection;
    }

    /**
     * @desc Schließt die aktuelle Verbindung.
     */
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
