
import generated.Auftrag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Florian
 */
public class TestManipulateXmlFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Auftrag auftrag;
        String[] result;
        System.out.println("XML-File 1.xml auslesen");
        auftrag = (Auftrag) ManipulateXmlFile.loadXmlFile(Auftrag.class, "1");
        System.out.println("Id: " + auftrag.getId());
        System.out.println("Beschreibung: " + auftrag.getBeschreibung());
        System.out.println("Status: " + auftrag.getStatus());
        System.out.println("Gebäude: " + auftrag.getGebaeude());

        System.out.println("\nneues XML-File anlegen --> Id muss anders sein");
        auftrag.setBeschreibung(auftrag.getBeschreibung() + "\n" + auftrag.getBeschreibung());
        auftrag.setStatus("angelegt");
        auftrag.setId(2);
        result = ManipulateXmlFile.saveXmlFile(Auftrag.class, auftrag);        
        System.out.println("File: "+result[0]+" | Dir: "+result[1]);

        System.out.println("\nXML-File updaten --> zunaechst XML-File auslesen, dann manipulieren");
        auftrag.setStatus("neuer Status 2");
        result = ManipulateXmlFile.saveXmlFile(Auftrag.class, auftrag);
        System.out.println("File: "+result[0]+" | Dir: "+result[1]);
    }

}
