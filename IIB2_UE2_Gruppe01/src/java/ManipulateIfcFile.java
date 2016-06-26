
import ifc2x3javatoolbox.ifc2x3tc1.IfcBuildingElement;
import ifc2x3javatoolbox.ifc2x3tc1.IfcComplexProperty;
import ifc2x3javatoolbox.ifc2x3tc1.IfcDoor;
import ifc2x3javatoolbox.ifc2x3tc1.IfcElement;
import ifc2x3javatoolbox.ifc2x3tc1.IfcGloballyUniqueId;
import ifc2x3javatoolbox.ifc2x3tc1.IfcIdentifier;
import ifc2x3javatoolbox.ifc2x3tc1.IfcLabel;
import ifc2x3javatoolbox.ifc2x3tc1.IfcObject;
import ifc2x3javatoolbox.ifc2x3tc1.IfcOwnerHistory;
import ifc2x3javatoolbox.ifc2x3tc1.IfcProject;
import ifc2x3javatoolbox.ifc2x3tc1.IfcProperty;
import ifc2x3javatoolbox.ifc2x3tc1.IfcPropertySet;
import ifc2x3javatoolbox.ifc2x3tc1.IfcPropertySetDefinition;
import ifc2x3javatoolbox.ifc2x3tc1.IfcPropertySingleValue;
import ifc2x3javatoolbox.ifc2x3tc1.IfcRelDefines;
import ifc2x3javatoolbox.ifc2x3tc1.IfcRelDefinesByProperties;
import ifc2x3javatoolbox.ifc2x3tc1.IfcText;
import ifc2x3javatoolbox.ifc2x3tc1.IfcWindow;
import ifc2x3javatoolbox.ifc2x3tc1.SET;
import ifc2x3javatoolbox.ifcmodel.IfcModel;
import java.io.File;
import java.io.IOException;
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
public class ManipulateIfcFile {

    String ifcPath = "";
    String ifcFilename = "";
    File ifcFile = null;
    IfcModel ifcModel = new IfcModel();

    public ManipulateIfcFile(String path, String filename) {
        this.ifcModel = new IfcModel();
        this.ifcPath = path;
        this.ifcFilename = filename;
        this.loadFile();
    }

    private boolean loadFile() {
        try {
            this.ifcFile = new File(this.ifcPath + this.ifcFilename);
            this.ifcModel.readStepFile(this.ifcFile);
            return true;
        } catch (Exception e) {
            System.out.println("Fehler beim Laden des Ifc-Files.");
            e.printStackTrace();
        }
        return false;
    }

    private boolean loadFile(String path, String filename) {
        this.ifcPath = path;
        this.ifcFilename = filename;
        return this.loadFile();
    }

    public boolean saveFile() {
        try {
            this.ifcModel.writeStepfile(this.ifcFile);
            return true;
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern des Ifc-Files.");
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveFile(String path, String filename) {
        this.ifcPath = path;
        this.ifcFilename = filename;
        try {
            this.ifcFile = new File(this.ifcPath + this.ifcFilename);
        } catch (Exception e) {
            System.out.println("Fehler beim Speichern des Ifc-Files.");
            e.printStackTrace();
        }
        return this.saveFile();
    }

    public Collection getElements(String typInSingular) {
        switch (typInSingular.toLowerCase()) {
            case "door":
            case "tuer":
                return this.getElements(0);
            case "window":
            case "fenster":
                return this.getElements(1);
        }
        return null;
    }

    public Collection getElements(int typ) {
        switch (typ) {
            case 0:
                return (Collection<IfcDoor>) this.ifcModel.getCollection(IfcDoor.class);
            case 1:
                return (Collection<IfcWindow>) this.ifcModel.getCollection(IfcWindow.class);
        }
        return null;
    }

    /*private IfcBuildingElement getElement(Collection ifcElements, String name) {
        if (ifcElements.isEmpty()) {
            throw new NullPointerException("Fehler, da leere Elementliste.");
        }
        for (Iterator i = ifcElements.iterator(); i.hasNext();) {
            IfcBuildingElement element =  (IfcBuildingElement) i.next();
            if (element.getName().getDecodedValue().equals(name)) {
                ifcElement = element;
            }
        }
    }*/
    public IfcBuildingElement getElement(Collection<IfcBuildingElement> ifcElements, String name) {
        if (ifcElements.isEmpty()) {
            throw new NullPointerException("Fehler, da leere Elementliste.");
        }
        for (IfcBuildingElement element : ifcElements) {
            if (element.getName().getDecodedValue().equals(name)) {
                return element;
            }
        }
        return null;
    }

    private void addPropertySet(IfcBuildingElement element, String name, String description) {
        IfcGloballyUniqueId globalId = new IfcGloballyUniqueId(this.ifcModel.getNewGlobalUniqueId());
        IfcOwnerHistory ownerHistory = new IfcOwnerHistory();
        for (IfcProject item : this.ifcModel.getCollection(IfcProject.class)) {
            ownerHistory = item.getOwnerHistory();
        }
        IfcLabel propertyName = new IfcLabel(name, false);
        IfcText propertyDescription = new IfcText(description, false);
        IfcPropertySetDefinition propertySetDefinition = new IfcPropertySet(globalId, ownerHistory, propertyName, propertyDescription, new SET());
        this.ifcModel.addIfcObject(propertySetDefinition);

        IfcRelDefinesByProperties relDefinesByProperties = new IfcRelDefinesByProperties();
        relDefinesByProperties.setRelatingPropertyDefinition(propertySetDefinition);
        SET<IfcObject> tempSet = new SET<>();
        tempSet.add(element);
        relDefinesByProperties.setRelatedObjects(tempSet);
        this.ifcModel.addIfcObject(relDefinesByProperties);
    }

    public IfcPropertySet getPropertySet(IfcBuildingElement element, String name) {
        if (element.getIsDefinedBy_Inverse() != null) {
            for (IfcRelDefines relDefines : element.getIsDefinedBy_Inverse()) {
                if (relDefines instanceof IfcRelDefinesByProperties) {
                    IfcRelDefinesByProperties relDefinesByProperties = (IfcRelDefinesByProperties) relDefines;
                    IfcPropertySetDefinition propertySetDefinition = (IfcPropertySetDefinition) relDefinesByProperties.getRelatingPropertyDefinition();
                    if (propertySetDefinition instanceof IfcPropertySet) {
                        IfcPropertySet propertySet = (IfcPropertySet) propertySetDefinition;
                        if (propertySet.getName().getDecodedValue().equals(name)) {
                            return propertySet;
                        }
                    }
                }
            }
        }
        return null;
    }

    public IfcPropertySingleValue createIfcPropertySingleValue(String name, String descriptionKey, String descriptionValue) {
        return new IfcPropertySingleValue(
                new IfcIdentifier(name, false),
                new IfcText(descriptionValue, false),
                new IfcText(descriptionKey, false),
                null);
    }

    public IfcComplexProperty createIfcComplexProperty(String name, String descriptionKey, String descriptionValue) {
        return new IfcComplexProperty(
                new IfcIdentifier(name, false),
                new IfcText(descriptionValue, false),
                new IfcIdentifier(descriptionKey, false),
                new SET<>());
    }

    public IfcPropertySet addIfcPropertySingleValue(ArrayList<IfcPropertySingleValue> properties, IfcPropertySet destinationProperty) {
        for (IfcPropertySingleValue property : properties) {
            this.ifcModel.addIfcObject(property);
            destinationProperty.addHasProperties(property);
        }
        return destinationProperty;
    }

    public IfcComplexProperty addIfcComplexProperty(ArrayList<IfcPropertySingleValue> properties, IfcComplexProperty destinationProperty, IfcPropertySet parentProperty) {
        for (IfcPropertySingleValue property : properties) {
            destinationProperty.addHasProperties(property);
        }
        this.addPropertyToIfcModel(destinationProperty);
        parentProperty.addHasProperties(destinationProperty);
        return destinationProperty;
    }

    private void addPropertyToIfcModel(IfcProperty property) {
        if (property instanceof IfcComplexProperty) {
            this.ifcModel.addIfcObject(property);
            IfcComplexProperty complexProperty = (IfcComplexProperty) property;
            for (IfcProperty p : complexProperty.getHasProperties()) {
                this.addPropertyToIfcModel(p);
            }
        } else {
            this.ifcModel.addIfcObject(property);
        }
    }

    public static void deletePropertySet(IfcModel model, IfcElement ifcElement, String propertySetName) {
        if (ifcElement.getIsDefinedBy_Inverse() != null) {
            for (IfcRelDefines ifcRelDefines : ifcElement.getIsDefinedBy_Inverse()) {
                if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
                    IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
                    IfcPropertySetDefinition ifcPropertySetDefinition = (IfcPropertySetDefinition) ifcRelDefinesByProperties.getRelatingPropertyDefinition();
                    if (ifcPropertySetDefinition instanceof IfcPropertySet) {
                        IfcPropertySet ifcPropertySet = (IfcPropertySet) ifcPropertySetDefinition;
                        if (ifcPropertySet.getName().toString().equals(propertySetName)) {
                            for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
                                deleteProperty(model, ifcProperty);
                            }
                            ifcRelDefinesByProperties.removeRelatedObjects((IfcObject) ifcElement);
                            model.removeIfcObject(ifcRelDefinesByProperties);
                            model.removeIfcObject(ifcPropertySetDefinition);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void deleteProperty(IfcModel model, IfcProperty ifcProperty) {
        if (ifcProperty instanceof IfcComplexProperty) {
            IfcComplexProperty complexProperty = (IfcComplexProperty) ifcProperty;
            for (IfcProperty p : complexProperty.getHasProperties()) {
                deleteProperty(model, p);
            }
            model.removeIfcObject(ifcProperty);
        } else {
            model.removeIfcObject(ifcProperty);
        }
    }
}
