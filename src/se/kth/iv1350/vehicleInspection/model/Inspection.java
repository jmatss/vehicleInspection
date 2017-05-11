package se.kth.iv1350.vehicleInspection.model;

import se.kth.iv1350.vehicleInspection.DTO.VehicleDTO;
/**
 * Denna klass tar hand om allting som har med en inspektion att göra
 */
public class Inspection {
    private VehicleDTO vehicle;
    private PartToInspect[] partsToInspect;
    private int currentPartToInspectIndex;
    private boolean inspectionFinished;
    private Cost cost;
   
    /**
     * Konstruktor för inspection
     * @param vehicle Fordonet som ska inspekteras 
     * @param partsToInspect Delarna på fordonet som ska inspekteras
     */
    public Inspection(VehicleDTO vehicle, PartToInspect[] partsToInspect){
        this.vehicle = vehicle;
        this.partsToInspect = partsToInspect;
        this.currentPartToInspectIndex = 0;
        this.inspectionFinished = false;
        
        this.cost = new Cost(partsToInspect);
    }
    
    /**
     * Jämför två inspektioner
     * @param obj ska jämföras med detta objekt
     * @return true om inspektionerna är lika, false om dom är olika
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Inspection))
            return false;
        Inspection inspection = (Inspection)obj;
        
        // jämför regnummer
        if (!(this.vehicle.equals(inspection.getVehicle())))
            return false;
        
        // jämför antal delar
        int amountOfPartsInThisInspection = 0;
        int amountOfPartsInParamInspection = 0;
        
        while (this.getNextPartToInspect() != null)
            amountOfPartsInThisInspection++;
        
        while (inspection.getNextPartToInspect() != null)
            amountOfPartsInParamInspection++;
        
        if (amountOfPartsInThisInspection != amountOfPartsInParamInspection)
            return false;
        
        // jämför namn på delarna
        PartToInspect currentPartFromThisInspection;
        PartToInspect currentPartFromParamInspection;
        
        while ((currentPartFromThisInspection = this.getNextPartToInspect()) != null
              && (currentPartFromParamInspection = inspection.getNextPartToInspect()) != null) {
            
            if (!(currentPartFromThisInspection.equals(currentPartFromParamInspection)))
                return false;
        }
        
        return true;
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
    public void setInspectionFinished(){
        this.inspectionFinished = true;
    }
    
    /**
     * Hämtar "parten" på index currentPartToInspectIndex och ökar sedan
     * variabeln med ett så att den pekar på nästa part. Börjar om från början
     * och returar null när den nått slutet på arrayen.
     * @return returnar partToInspect på index currentPartToInspectIndex
     */
    public PartToInspect getNextPartToInspect(){
        if (this.currentPartToInspectIndex > this.partsToInspect.length -1) {
            this.currentPartToInspectIndex = 0;
            return null;
        }
        return this.partsToInspect[this.currentPartToInspectIndex++];
    }
    
    /**
     * Sätter pass på del som har inspekterats
     * @param partToInspect parten som har inspekterats
     */
    public void setResult(PartToInspect partToInspect, boolean result) {
        for (int i = 0; i < this.partsToInspect.length; i++) {
            if (partToInspect.equals(partsToInspect[i])) {
                partsToInspect[i].setResult(result);
                break;
            }
        }
    }

    /**
     * 
     * @return en referens till cost objektet
     */
    public Cost getCost() {
        return this.cost;
    }
}
