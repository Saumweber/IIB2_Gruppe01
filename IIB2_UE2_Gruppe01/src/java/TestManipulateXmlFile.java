
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
        // TODO code application logic here
        Auftrag auftrag;
        auftrag = (Auftrag) ManipulateXmlFile.getObjectOutOfXmlFile(Auftrag.class, "1");

        auftrag.setBeschreibung("\n" + auftrag.getBeschreibung() + "\n" + auftrag.getBeschreibung());
        auftrag.setId(2);
        String[] result = ManipulateXmlFile.createXmlFile(Auftrag.class, auftrag);
    }
}