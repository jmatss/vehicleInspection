package se.kth.iv1350.vehicleInspection.model;

/**
 * Visar currentNumber på en skärm
 */
public class Display {
    private int numberOnDisplay;
    
    /**
     * Skapar displayen och sätter den till 0
     */
    public Display() {
        this.numberOnDisplay = 0;
    }
    
    /**
     * returnar numret på skärmen
     * @return numret som visas på skärmen
     */
    public int getNumberOnDisplay() {
        return this.numberOnDisplay;
    }
    
    /**
     * Byter vad som visas på skärmen
     * @param currentNumber Nya värdet som ska visas på skärmen
     */
    void showOnDisplay(int currentNumber) {
        this.numberOnDisplay = currentNumber;
        System.out.println("Displaynummer uppdaterat till: " + this.numberOnDisplay);
    }
}
