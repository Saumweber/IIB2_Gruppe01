
import ifc2x3javatoolbox.ifc2x3tc1.IfcBuildingElement;
import ifc2x3javatoolbox.ifc2x3tc1.IfcComplexProperty;
import ifc2x3javatoolbox.ifc2x3tc1.IfcPropertySet;
import ifc2x3javatoolbox.ifc2x3tc1.IfcPropertySingleValue;
import java.util.ArrayList;
import java.util.Collection;

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
        String ifcPath = "D:/Desktop/IIB2_Gruppe01/IIB2_UE2_Gruppe01/ifc/";
        String ifcFilename = "IIB2_SS2016_HU3_AC-11-Smiley-West-04-07-2007.ifc";
        String elementTyp = "Tuer";
        String elementName = "EG-Terrasse-1-2";
        String propertyName = "Pset_DoorCommon";

                System.out.println("IFC-File öffnen:");
        ManipulateIfcFile manipulateIfcFile = new ManipulateIfcFile(ifcPath, ifcFilename);
                System.out.println(ifcPath+ifcFilename+" geöffnet.");
        
                System.out.println("\nZugriff auf alle Elemente einer Ebene: ");
        Collection col = manipulateIfcFile.getElements(elementTyp);
                System.out.println(col.size() + " Elemente.");
                System.out.println("\nZugriff auf genau ein Element einer Ebene: ");
        IfcBuildingElement element = manipulateIfcFile.getElement(col, elementName);
                System.out.println(elementName + " gefunden.");

                System.out.println("\nZugriff auf PropertySet (simple und complex) eines Elements: ");
        IfcPropertySet propertySet_Search = manipulateIfcFile.getPropertySet(element, propertyName);
                System.out.println(propertyName + " gefunden.");

                System.out.println("\nPropertySet (simple) erstellen: ");
        IfcPropertySingleValue propertySetSimple = manipulateIfcFile.createIfcPropertySingleValue("Auftrag", "beschreibung kurz", "beschreibung lang");
        ArrayList<IfcPropertySingleValue> listSimple = new ArrayList<IfcPropertySingleValue>();
        listSimple.add(propertySetSimple);
        manipulateIfcFile.addIfcPropertySingleValue(listSimple, propertySet_Search);
                System.out.println("PropertySet (simple) hinzugefuegt.");
                
                        manipulateIfcFile.addIfcPropertySingleValue(listSimple, propertySet_Search);
                System.out.println("PropertySet (simple) hinzugefuegt.");
      
                System.out.println("\nPropertySet (complex) erstellen: ");
        IfcComplexProperty propertySetComplex = manipulateIfcFile.createIfcComplexProperty("AuftragA", "beschreibung kurz", "beschreibung lang");
        ArrayList<IfcPropertySingleValue> listComplex = new ArrayList<IfcPropertySingleValue>();
        listComplex.add(manipulateIfcFile.createIfcPropertySingleValue("Beschreibung1", "key1", "value1"));
        listComplex.add(manipulateIfcFile.createIfcPropertySingleValue("Beschreibung2", "key2", "value2"));
        manipulateIfcFile.addIfcComplexProperty(listComplex, propertySetComplex, propertySet_Search);
                System.out.println("PropertySet (complex) angelegt.");

                System.out.println("\nIFC-File speichern:");
        manipulateIfcFile.saveFile();
                System.out.println("\nIFC-File gespeichert.");
             
                System.out.println("\nIFC-File löschen:");
        //ManipulateIfcFile.deleteProperty(model, propertySetSimple);
        //ManipulateIfcFile.deletePropertySet(model, propertySetSimple);
                System.out.println("\nIFC-File gelöscht.");
    }
}
