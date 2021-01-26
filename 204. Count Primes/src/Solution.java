import java.util.List;

public class Solution {

    public static void main(String[] args) {

        final var caseLength = 3;
        final var n = List.of(10,0,1);
        final var output = List.of(4,0,0);

        for (int i = 0; i < caseLength; i++) {

            final var expected = output.get(i);
            final var myOutput = countPrimes(n.get(i));

            if (expected != myOutput) {
                System.out.println("FAIL");
                System.out.println("Case: " + (i + 1));
                System.out.println("Expected: " + expected);
                System.out.println("MyOutput: " + myOutput);
                return;
            }

        }

        System.out.println("SUCCESS");

    }

    public static int countPrimes(int n) {

        boolean[] prime = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p])
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        int result = 0;
        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i])
                ++result;
        }

        return result;
    }
    

}
