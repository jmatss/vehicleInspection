package se.kth.iv1350.vehicleInspection.view;

import se.kth.iv1350.vehicleInspection.controller.Controller;

/**
 * All in- och utmatning sker via denna klass
 */
public class View {
    private Controller contr;
    
    /**
     * skapar view
     * @param contr ger view en referens till controllern
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * All in- och utmatning sker via denna metod
     */
    public void hardcodedCallsFromView() {
        
    }
}
