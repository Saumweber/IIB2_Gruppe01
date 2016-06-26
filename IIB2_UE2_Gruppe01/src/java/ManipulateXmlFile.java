
import generated.Auftrag;
import generated.ObjectFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Florian
 */
public class ManipulateXmlFile {

    static String xmlPath;
    static FileInputStream xmlFile;
    static JAXBContext context;
    static Auftrag auftrag;
    static boolean verbose;

    static {
        xmlPath = "./web/xml/";
        try {
            context = JAXBContext.newInstance("generated");
            // JAXBContext context = JAXBContext.newInstance("Auftrag.class");
        } catch (JAXBException e) {
            System.out.println("Fehler beim Erstellen des JAXB-Binding.");
            e.printStackTrace();
        }
        verbose = true;
    }

    public static Object loadXmlFile(Class returntypeOfObject, String filenameWithoutExtension) {
        try {
            xmlFile = new FileInputStream("./web/xml/1.xml");//xmlPath + filenameWithoutExtension + ".xml");
            Unmarshaller um = context.createUnmarshaller();
            if (returntypeOfObject.equals(Auftrag.class)) {
                auftrag = (Auftrag) um.unmarshal(xmlFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fehler beim Auffinden der Datei.");
            if (verbose) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            System.out.println("Fehler beim Erstellen des JAXB-Binding.");
            if (verbose) {
                e.printStackTrace();
            }
        }
        return auftrag;
    }

    public static Object loadXmlFile(Class returntypeOfObject, String filenameWithoutExtension, boolean detailedError) {
        verbose = detailedError;
        return loadXmlFile(returntypeOfObject, filenameWithoutExtension);
    }

    public static Object loadXmlFile(Class returntypeOfObject, String filenameWithoutExtension, String pathWithClosingSlash) {
        xmlPath = pathWithClosingSlash;
        return loadXmlFile(returntypeOfObject, filenameWithoutExtension);
    }

    public static Object loadXmlFile(Class returntypeOfObject, String filenameWithoutExtension, String pathWithClosingSlash, boolean detailedError) {
        verbose = detailedError;
        xmlPath = pathWithClosingSlash;
        return loadXmlFile(returntypeOfObject, filenameWithoutExtension);
    }

    public static String[] saveXmlFile(Class typeOfInstanceObject, Object instanceObject) {
        String dir = "";
        String filename = "";
        try {
            ObjectFactory factory = new ObjectFactory();
            Marshaller ma = context.createMarshaller();
            if (typeOfInstanceObject.equals(Auftrag.class)) {
                Auftrag auftragNew;
                auftrag = (Auftrag) instanceObject;
                auftragNew = factory.createAuftrag();
                auftragNew.setBeschreibung(auftrag.getBeschreibung());
                auftragNew.setGloballyUniqueId(auftrag.getGloballyUniqueId());
                auftragNew.setId(auftrag.getId());
                auftragNew.setStatus(auftrag.getStatus());
                dir = xmlPath;
                filename = auftragNew.getId() + ".xml";
                ma.marshal(auftragNew, new FileOutputStream(dir + filename));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fehler beim Auffinden der Datei.");
            if (verbose) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            System.out.println("Fehler beim Erstellen des JAXB-Binding.");
            if (verbose) {
                e.printStackTrace();
            }
        }
        return new String[]{filename, dir};
    }

    public static String[] saveXmlFile(Class typeOfInstanceObject, Object instanceObject, boolean detailedError) {
        verbose = detailedError;
        return saveXmlFile(typeOfInstanceObject, instanceObject);
    }

    public static String[] saveXmlFile(Class typeOfInstanceObject, Object instanceObject, String pathWithClosingSlash) {
        xmlPath = pathWithClosingSlash;
        return saveXmlFile(typeOfInstanceObject, instanceObject);
    }

    public static String[] saveXmlFile(Class typeOfInstanceObject, Object instanceObject, String pathWithClosingSlash, boolean detailedError) {
        verbose = detailedError;
        xmlPath = pathWithClosingSlash;
        return saveXmlFile(typeOfInstanceObject, instanceObject);
    }
}
