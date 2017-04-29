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
    Cost(PartToInspect[] partsToInspect) {
        calculateCost(partsToInspect);
    }

    /**
     * returnar kostnadamount
     * @return kostnaden
     */
    public float getAmount() {
        return this.amount;
    }
    
    private void calculateCost(PartToInspect[] partsToInspect) {
        // 10 kr per del, bra pris
        this.amount = (float)partsToInspect.length*10;
    }
    
}
