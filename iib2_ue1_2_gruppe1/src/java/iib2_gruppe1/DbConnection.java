package iib2_gruppe1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Florian Saumweber: 2354534
 * @author Benjamin Krauß: 2388173
 */

/*
* Diese Datei bzw. genauer dieses Paket gehört eigentlich ausgelagert.
* Allerdings wird davon ausgegangen, dass die einzelnen Projekte/ Hausübungen
* nur lokal begutachtet/ deployed werden. Dadurch kann der Fall eintreten, dass
* der Import dieses Pakets in das jeweilige Projekt (z.B. ue1_1 oder ue1_2) 
* nicht funktioniert, da nicht alle Projekte (z.B. dieses Paket als Projekt 
* implementiert, ue1_1 oder ue1_2) bereits im Netbeans importiert sein müssen. 
* Ein möglicher, aber für den Umfang der Hausübungen nicht rechtfertigender 
* Ansatz wäre gewesen, dieses Paket als Klasse zu implementieren, zu kompilieren 
* und dann jeweils als .jar bzw. als Projekt-jar in die Librarie eines jeden 
* Projektes hinzuzufügen. Diese Abhängigkeiten untereinander machen jedoch das
* Nachvollziehen der einzelnen Hausübungen unnötig schwierig.
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
        this.database = "iib2_ue1_2_gruppe1";
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
