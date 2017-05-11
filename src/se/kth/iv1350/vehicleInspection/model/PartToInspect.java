package se.kth.iv1350.vehicleInspection.model;

/**
 * En del som ska inspekteras
 */
public class PartToInspect {
    private String name;
    private boolean result;
    
    /**
     * Skapar en del och sätter den till icke godkänd
     * @param name namn på delen
     */
    public PartToInspect(String name) {
        this.name = name;
        this.result = false;
    }
    
    /**
     * Jämför namn på två delar
     * @param obj ska jämföras med detta objekt
     * @return true om delarna har samma namn, false om har olika
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PartToInspect))
            return false;
        PartToInspect partToInspect = (PartToInspect)obj;
        
        return this.name == partToInspect.getName();
    }
    
    /**
     * returnar namnet på denna del
     * @return namnet på denna del
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * hämtar resultatet
     * @return True = godkänd, false = icke godkänd
     */
    public boolean getResult() {
        return this.result;
    }
    
    /**
     * Godkänner denna del
     */
    public void setResult(boolean result) {
        this.result = result;
    }
}
