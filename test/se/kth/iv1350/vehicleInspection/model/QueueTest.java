package se.kth.iv1350.vehicleInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    /**
     * Test of updateQueue method, of class Queue.
     */
    @Test
    public void testQueueUpdatesCorrectly() {
        Display display = new Display();
        Queue instance = new Queue(display);
        instance.updateQueue();
        int result = instance.getCurrentNumber();
        int expResult = 1;
        assertEquals("Uppdatering av könummer funkar ej korrekt!", result, expResult);
    }
}
