/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import generated.Auftrag;
import java.io.FileInputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Florian
 */
public class ManipulateXml {

    Auftrag auftrag = new Auftrag();
    FileInputStream xmlFile;

    public void main(String[] args) {
        try {
            xmlFile = new FileInputStream("xml/1.xml");
            JAXBContext context = JAXBContext.newInstance("generated");
            // JAXBContext context = JAXBContext.newInstance("Auftrag.class");
            Unmarshaller um = context.createUnmarshaller();
            auftrag = (Auftrag) um.unmarshal(xmlFile);
        } catch (Exception e) {
        }
    }
}
