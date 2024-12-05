public class Primes {
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        printPrimes(n);
    }
    public static void printPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1]; 
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                int multiple = p * p;
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += p;
                }
            }
            p++;
        }
        int primeCount = 0;
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }
        double percentage = (primeCount / (double)(n )) * 100; 
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + String.format("%.0f", percentage) + "% are primes)");
    }
}
