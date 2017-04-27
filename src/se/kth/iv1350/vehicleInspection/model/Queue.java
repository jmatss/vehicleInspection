package se.kth.iv1350.vehicleInspection.model;

/**
 * Tar hand om allting som har med kön att göra
 */
public class Queue {
    private int currentNumber;
    private Display display;
    
    /**
     * Konstruktor för queuen
     * @param display Dsiplayen där currentnumber ska visas
     */
     public Queue(Display display) {
        this.display = display;
        this.currentNumber = 0;
    }
    
    public int getCurrentNumber(){
        return this.currentNumber;
    }
    
    /**
     * Uppdaterar currentNumber och skriver det till displayen
     */
    public void updateQueue() {
        this.currentNumber++;
    }
}
