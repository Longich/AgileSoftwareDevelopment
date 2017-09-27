package main.java.refactoring;

public class GeneratePrimes {
    public static int[] generatePrimes(int maxValue) {
        if (maxValue >= 2) {
            int s = maxValue + 1;
            boolean[] f = new boolean[s];
            int i;
        
            for (i = 0; i < s; i++) {
                f[i] = true;
            }
            
            f[0] = f[1] = false;
            
            int j;
            for (i = 2; i < Math.sqrt(s); i++) {
                if (f[i]) {
                    for (j = 2 * i; j < s; j += i) {
                        f[j] = false;
                    }
                }
            }
            
            int count = 0;
            for (i = 0; i < s; i++) {
                if (f[i]) {
                    count++;
                }
            }
            int[] primes = new int[count];
            
            for (i = 0, j = 0; i < s; i++) {
                if (f[i]) {
                    primes[j++] = i;
                }
            }
            return primes;
        } else { //maxValue < 2
            return new int[0]; // null配列を戻す
        }
    }
}
