package test.java.refactoring;

import junit.framework.TestCase;
import main.java.refactoring.GeneratePrimes;

public class TestGeneratePrimes extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.main(new String[] {"TestGeneratePrimes"});
    }
    
    public TestGeneratePrimes(String name) {
        super(name);
    }
    
    public void testPrimes() {
        int[] nullArray = GeneratePrimes.generatePrimes(0);
        assertEquals(nullArray.length, 0);
    }
}
