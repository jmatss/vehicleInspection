package se.kth.iv1350.vehicleInspection.model;

/**
 * Denna klass tar hand om allting som har med en inspektion att göra
 */
public class Inspection {
    private VehicleDTO vehicle;
    private PartToInspect[] partsToInspect;
    private int currentPartToInspectIndex;
    private boolean inspectionFinished = false;
   
    /**
     * Konstruktor för inspection
     * @param vehicle Fordonet som ska inspekteras 
     * @param partsToInspect Delarna på fordonet som ska inspekteras
     */
    Inspection(VehicleDTO vehicle, PartToInspect[] partsToInspect){
        this.vehicle = vehicle;
        this.partsToInspect = partsToInspect;
        currentPartToInspectIndex = 0;
    }
    
    /**
     * Hämtar vehicle
     * @return returnar vehicle
     */
    public VehicleDTO getVehicle(){
        return this.vehicle;
    }
    
    /**
     * Används för att kolla om inspektionen har genomförts eller inte
     * @return true om inspektionen har genomförts, false om den inte har
     * genomförts
     */
    public boolean getInspectionFinished(){
        return this.inspectionFinished;
    }
    
    /**
     * Sätter inspectionFinished till true, alltså att den har genomförts
     */
    private void setInspectionFinished(){
        this.inspectionFinished = true;
    }
    
    /**
     * Hämtar "parten" på index currentPartToInspectIndex och går ökar sedan
     * variabeln med ett så att den pekar på nästa part
     * @return returnar partToInspect på index currentPartToInspectIndex
     */
    public PartToInspect getNextPartToInspect(){
        
    }
    
    /**
     * Sätter pass eller fail på del som har inspekterats
     * @param partToInspect parten som har inspekterats
     * @param result true = pass, false = fail
     */
    public void setPassOrFail(PartToInspect partToInspect, boolean result) {
        
    }
    
    /**
     * Skickar resultat till printer för utskrift
     */
    public void printResult () {
        
    }
    
    /**
     * Skickar receipt till printer för utskrift
     */
    public void printReceipt() {
        
    }
}
