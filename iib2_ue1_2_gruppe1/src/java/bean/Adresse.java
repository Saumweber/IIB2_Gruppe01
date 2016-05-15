package bean;
// Generated 15.05.2016 11:05:36 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Adresse generated by hbm2java
 */
public class Adresse  implements java.io.Serializable {


     private Integer adrId;
     private String adrStrasse;
     private String adrHausnummer;
     private String adrPlz;
     private String adrOrt;
     private String adrLand;
     private Set handwerkers = new HashSet(0);
     private Set eigentuemers = new HashSet(0);
     private Set gebaeudes = new HashSet(0);
     private Set gutachters = new HashSet(0);

    public Adresse() {
    }

    public Adresse(String adrStrasse, String adrHausnummer, String adrPlz, String adrOrt, String adrLand, Set handwerkers, Set eigentuemers, Set gebaeudes, Set gutachters) {
       this.adrStrasse = adrStrasse;
       this.adrHausnummer = adrHausnummer;
       this.adrPlz = adrPlz;
       this.adrOrt = adrOrt;
       this.adrLand = adrLand;
       this.handwerkers = handwerkers;
       this.eigentuemers = eigentuemers;
       this.gebaeudes = gebaeudes;
       this.gutachters = gutachters;
    }
   
    public Integer getAdrId() {
        return this.adrId;
    }
    
    public void setAdrId(Integer adrId) {
        this.adrId = adrId;
    }
    public String getAdrStrasse() {
        return this.adrStrasse;
    }
    
    public void setAdrStrasse(String adrStrasse) {
        this.adrStrasse = adrStrasse;
    }
    public String getAdrHausnummer() {
        return this.adrHausnummer;
    }
    
    public void setAdrHausnummer(String adrHausnummer) {
        this.adrHausnummer = adrHausnummer;
    }
    public String getAdrPlz() {
        return this.adrPlz;
    }
    
    public void setAdrPlz(String adrPlz) {
        this.adrPlz = adrPlz;
    }
    public String getAdrOrt() {
        return this.adrOrt;
    }
    
    public void setAdrOrt(String adrOrt) {
        this.adrOrt = adrOrt;
    }
    public String getAdrLand() {
        return this.adrLand;
    }
    
    public void setAdrLand(String adrLand) {
        this.adrLand = adrLand;
    }
    public Set getHandwerkers() {
        return this.handwerkers;
    }
    
    public void setHandwerkers(Set handwerkers) {
        this.handwerkers = handwerkers;
    }
    public Set getEigentuemers() {
        return this.eigentuemers;
    }
    
    public void setEigentuemers(Set eigentuemers) {
        this.eigentuemers = eigentuemers;
    }
    public Set getGebaeudes() {
        return this.gebaeudes;
    }
    
    public void setGebaeudes(Set gebaeudes) {
        this.gebaeudes = gebaeudes;
    }
    public Set getGutachters() {
        return this.gutachters;
    }
    
    public void setGutachters(Set gutachters) {
        this.gutachters = gutachters;
    }




}

