import java.util.List;

public class Solution {

    public static void main(String[] args) {

        final var caseLength = 2;
        final var n = List.of(2, 3);
        final var output = List.of(2, 3);

        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = climbStairs2(n.get(i));

            if (expected != myOutput) {
                System.out.println("FAIL");
                System.out.println("Case: " + (i + 1));
                System.out.println("Expected: " + expected);
                System.out.println("MyOutput: " + myOutput);
                return;
            }
        }

        System.out.println("SUCCESS");

        System.out.println(climbStairs2(44));

    }

    // O(2^n) slow solution
    public static int climbStairs(int n) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);


    }

    //O(n) fast solution with dynamic programming
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }



}
