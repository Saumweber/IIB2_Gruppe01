
import iib.ifc.IIB_IfcModelHandler;
import java.io.File;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Florian
 */
public class TestManipulateIfcFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ifcPath = "D:/Desktop/IIB2_Gruppe01/IIB2_UE2_Gruppe01/ifc/";
        String ifcFile = "IIB2_SS2016_HU3_AC-11-Smiley-West-04-07-2007.ifc";
        File file = new File(ifcPath + ifcFile);
        try {
            System.out.println(file.getAbsoluteFile());
            IIB_IfcModelHandler ifcModel = new IIB_IfcModelHandler(file);
        } catch (Exception e) {
            System.out.println("Fehler beim Laden des Ifc-Files.");
            e.printStackTrace();
        }
    }

}
