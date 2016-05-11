package iib2_gruppe1.ue1_1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Florian Saumweber: 2354534
 * @author Benjamin Krauß: 2388173
 */
public class Iib2_ue1_1_gruppe1 {

    /**
     * @desc Ein Konsolenprogramm, welches Kunden, Aufträge und Adressen in
     * einer Datenbank verwaltet.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int type = 0;
        ResultSet resultSet = null;
        String name = "";
        String vorname = "";
        String beschreibung = "";
        String kunde_id = "";
        boolean endLoop = false;
        int result = 0;

        DbConnection con = new DbConnection();
        while (!endLoop) {
            result = 0;
            System.out.println("Welche Aktion möchten Sie durchführen? Bitte Zahl eingeben.");
            System.out.println("1: neuen Kunden anlegen.");
            System.out.println("2: neuen Auftrag eingeben.");
            System.out.println("3: alle Kunden anzeigen.");
            System.out.println("4: alle Aufträge anzeigen.");
            System.out.println("5: alle Aufträge eines Kunden anzeigen.");
            System.out.println("0: Programm beenden.");
            try {
                System.out.print("Ihre Eingabe: ");
                type = Integer.valueOf(new Scanner(System.in).nextLine());
            } catch (Exception e) {
                System.out.println("Eingabe ist keine Zahl. Versuchen Sie es noch einmal.");
                type = Integer.MIN_VALUE;
            }
            System.out.println("... Verarbeitung Ihrer Eingabe.");
            System.out.println("----------------------------------------------------");

            switch (type) {
                case 0:
                    endLoop = true;
                    break;
                case 1:
                    System.out.print("Nachname des Kunden: ");
                    name = new Scanner(System.in).nextLine();
                    System.out.print("Vorname des Kunden: ");
                    vorname = new Scanner(System.in).nextLine();
                    result = con.iKunde(name, vorname);
                    if (result > 1) {
                        System.out.println("Es wurden " + result + " Kunden angelegt.");
                    } else if (result > 0) {
                        System.out.println("Es wurde " + result + " Kunde angelegt.");
                    } else if (result == 0) {
                        System.out.println("Es wurde kein Kunde angelegt.");
                    } else {
                        System.out.println("Es trat ein Fehler, versuchen Sie es noch einmal.");
                    }
                    break;
                case 4:
                    resultSet = con.sAuftrag();
                    try {
                        if (!resultSet.first()) {
                            System.out.println("Es sind keine Aufträge vorhanden.");
                        } else {
                            do {
                                System.out.println("Auftrag-Id: " + resultSet.getString(1)
                                        + " Beschreibung: " + resultSet.getString(2)
                                        + " erledigt: " + resultSet.getString(3)
                                        + " Auftraggeber: " + resultSet.getString(4));
                            } while (resultSet.next());
                        }
                    } catch (SQLException e) {
                        System.out.println("SQLException: " + e.getMessage());
                    }
                    break;
                case 2:
                case 3:
                case 5:
                    String showAllCustomers = "";
                    if (type == 2) {
                        System.out.print("Beschreibung des Auftrages: ");
                        beschreibung = new Scanner(System.in).nextLine();
                    }
                    if (type == 2 || type == 5) {
                        System.out.print("Kunden-Id des Auftraggebers. Wollen Sie zuvor die Kundenliste sehen (j/ n)? ");
                        showAllCustomers = new Scanner(System.in).nextLine();
                    }
                    if (type == 3 || showAllCustomers.equals("j")) {
                        resultSet = con.sKunde();
                        try {
                            if (!resultSet.next()) {
                                System.out.println("Es sind keine Kunden vorhanden.");
                            } else {
                                do {
                                    System.out.println("Kunden-Id: " + resultSet.getString(1)
                                            + " Name: " + resultSet.getString(2)
                                            + " Vorname: " + resultSet.getString(3));
                                } while (resultSet.next());
                            }
                        } catch (SQLException e) {
                            System.out.println("SQLException: " + e.getMessage());
                        }
                    }
                    if (type == 2 || type == 5) {
                        System.out.print("Kunden-Id des Auftraggebers: ");
                        kunde_id = new Scanner(System.in).nextLine();
                        try {
                            resultSet = con.sKunde(Integer.valueOf(kunde_id));
                            if (!resultSet.next()) {
                                System.out.println("Kunde " + kunde_id + " nicht gefunden. Aktion abgebrochen.");
                            } else if (type == 2) {
                                result = con.iAuftrag(beschreibung, Integer.valueOf(kunde_id));
                                if (result > 1) {
                                    System.out.println("Es wurden " + result + " Aufträge angelegt.");
                                } else if (result > 0) {
                                    System.out.println("Es wurde " + result + " Auftrag angelegt.");
                                } else if (result == 0) {
                                    System.out.println("Es wurde kein Auftrag angelegt.");
                                } else {
                                    System.out.println("Es trat ein Fehler, versuchen Sie es noch einmal.");
                                }
                            } else if (type == 5) {
                                resultSet = con.sAuftrag(Integer.valueOf(kunde_id), false);
                                if (!resultSet.next()) {
                                    System.out.println("Es sind keine Aufträge für Kunde " + kunde_id + " vorhanden.");
                                } else {
                                    do {
                                        System.out.println("Auftrag-Id: " + resultSet.getString(1)
                                                + " Beschreibung: " + resultSet.getString(2)
                                                + " erledigt: " + resultSet.getString(3)
                                                + " Auftraggeber: " + resultSet.getString(4));
                                    } while (resultSet.next());
                                }
                            }
                        } catch (SQLException e) {
                            System.out.println("SQLException: " + e.getMessage());
                        }
                        break;
                    }
            }
            System.out.println("----------------------------------------------------\n");
        }
        con.close();
    }
}
