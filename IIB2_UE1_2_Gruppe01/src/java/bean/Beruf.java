package bean;
// Generated 15.05.2016 11:05:36 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Beruf generated by hbm2java
 */
public class Beruf  implements java.io.Serializable {


     private Integer berId;
     private String berName;
     private String berSpezialisierung;
     private Set handwerkers = new HashSet(0);

    public Beruf() {
    }

    public Beruf(String berName, String berSpezialisierung, Set handwerkers) {
       this.berName = berName;
       this.berSpezialisierung = berSpezialisierung;
       this.handwerkers = handwerkers;
    }
   
    public Integer getBerId() {
        return this.berId;
    }
    
    public void setBerId(Integer berId) {
        this.berId = berId;
    }
    public String getBerName() {
        return this.berName;
    }
    
    public void setBerName(String berName) {
        this.berName = berName;
    }
    public String getBerSpezialisierung() {
        return this.berSpezialisierung;
    }
    
    public void setBerSpezialisierung(String berSpezialisierung) {
        this.berSpezialisierung = berSpezialisierung;
    }
    public Set getHandwerkers() {
        return this.handwerkers;
    }
    
    public void setHandwerkers(Set handwerkers) {
        this.handwerkers = handwerkers;
    }




}


