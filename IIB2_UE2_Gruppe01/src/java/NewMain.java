/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Florian
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ifcPath = "D:/Desktop/IIB2_Gruppe01/IIB2_UE2_Gruppe01/ifc/";
        String ifcFilename = "IIB2_SS2016_HU3_AC-11-Smiley-West-04-07-2007.ifc";

        ManipulateIfcFile manipulateIfcFile = new ManipulateIfcFile(ifcPath, ifcFilename);
        manipulateIfcFile.createIfcPropertySingleValue("Auftrag", "beschreibung kurz", "beschreibung lang");
        manipulateIfcFile.saveFile();

    }
    
}
