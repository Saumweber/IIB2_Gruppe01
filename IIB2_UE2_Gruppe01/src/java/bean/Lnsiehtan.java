package bean;
// Generated 20.06.2016 00:49:55 by Hibernate Tools 4.3.1



/**
 * Lnsiehtan generated by hbm2java
 */
public class Lnsiehtan  implements java.io.Serializable {


     private Integer lnsId;
     private Nutzer nutzer;
     private Sanierungsauftrag sanierungsauftrag;

    public Lnsiehtan() {
    }

    public Lnsiehtan(Nutzer nutzer, Sanierungsauftrag sanierungsauftrag) {
       this.nutzer = nutzer;
       this.sanierungsauftrag = sanierungsauftrag;
    }
   
    public Integer getLnsId() {
        return this.lnsId;
    }
    
    public void setLnsId(Integer lnsId) {
        this.lnsId = lnsId;
    }
    public Nutzer getNutzer() {
        return this.nutzer;
    }
    
    public void setNutzer(Nutzer nutzer) {
        this.nutzer = nutzer;
    }
    public Sanierungsauftrag getSanierungsauftrag() {
        return this.sanierungsauftrag;
    }
    
    public void setSanierungsauftrag(Sanierungsauftrag sanierungsauftrag) {
        this.sanierungsauftrag = sanierungsauftrag;
    }




}

