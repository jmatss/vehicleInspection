package se.kth.iv1350.vehicleInspection.model;

/**
 * Kostnaden för en inspektion
 */
public class Cost {
    private float amount;
    
    /**
     * Skapar cost och räknar ut kostnaden
     * @param inspection Inspektionen som ska betalas
     */
    Cost(Inspection inspection) {
        calculateCost(inspection);
    }
    
    /**
     * Räknar ut kostanden för inspektionen
     * @param inspection Inspektionen som ska betalas
     */
    private void calculateCost(Inspection inspection) {
        // 10 kr per del
        this.amount = (float)inspection.amountOfPartsToInspect() * 10;
    }
    
}
