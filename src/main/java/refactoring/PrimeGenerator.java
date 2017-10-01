package main.java.refactoring;

public class PrimeGenerator {
    private static boolean[] isCrossed;
    private static int[] result;
    
    public static int[] generatePrimes(int maxValue) {
        if (maxValue < 2) {
            return new int[0];
        } else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        isCrossed = new boolean[maxValue + 1];
        for (int i = 0; i < isCrossed.length; i++) {
            isCrossed[i] = false;
            
            //既知の非素数を取り除く
            isCrossed[0] = isCrossed[1] = true;
        }
    }
    private static void crossOutMultiples() {
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i < maxPrimeFactor; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static int calcMaxPrimeFactor() {
        double maxPrimeFactor = Math.sqrt(isCrossed.length) + 1;
        return (int) maxPrimeFactor;
    }
    
    private static boolean notCrossed(int i) {
        return isCrossed[i] == false;
    }
    
    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i;
             multiple < isCrossed.length;
             multiple += i) {
            isCrossed[multiple] = true;
        }
    }

    
    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberOfUncrossedIntegers()];
        
        for (int j = 0, i = 2; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                result[j++] = i;
            }
        }
    }
    
    private static int numberOfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < isCrossed.length; i++) {
            if (notCrossed(i)) {
                count++;
            }
        }
        return count;
    }
}
