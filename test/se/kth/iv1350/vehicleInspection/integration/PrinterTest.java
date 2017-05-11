package se.kth.iv1350.vehicleInspection.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.vehicleInspection.DTO.CreditCardDTO;
import se.kth.iv1350.vehicleInspection.model.Cost;
import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.model.PartToInspect;

public class PrinterTest {
    
    @Test
    public void testPrintReceipt() {
        PrintStream originalSysout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PartToInspect[] partsToInspect = new PartToInspect[1];
        partsToInspect[0] = new PartToInspect("brakes");
        
        Inspection inspection = new Inspection(null, partsToInspect);
        Printer instance = new Printer();
        instance.printReceipt(inspection);

        String expResult = "Receipt har skrivits ut!";
        String result = outContent.toString();

        assertTrue("Texten skrivs inte korrekt till system.out!", result.contains(expResult));
        outContent = null;
        System.setOut(originalSysout);
    }
    
    @Test
    public void testPrintResult() {
        PrintStream originalSysout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PartToInspect[] partsToInspect = new PartToInspect[1];
        partsToInspect[0] = new PartToInspect("brakes");
        
        Inspection inspection = new Inspection(null, partsToInspect);
        Printer instance = new Printer();
        instance.printResult(inspection);

        String expResult = "Inspection results har skrivits ut!";
        String result = outContent.toString();

        assertTrue("Texten skrivs inte korrekt till system.out!", result.contains(expResult));
        outContent = null;
        System.setOut(originalSysout);
    }
}
