import java.util.List;

public class Solution {
    private static final int M = 1337;

    public static void main(String[] args) {

        final var caseLength = 4;
        final var a = List.of(2, 2, 1, 2147483647);
        final var b = List.of(new int[]{3}, new int[]{1, 0}, new int[]{4, 3, 3, 8, 5, 2}, new int[]{2, 0, 0});
        final var output = List.of(8, 1024, 1, 1198);

        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = superPow(a.get(i), b.get(i));

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

    public static int normalPow(int a, int b) {
        int result = 1;
        while (b != 0) {
            if (b % 2 != 0)
                result = result * a % M;
            a = a * a % M;
            b /= 2;
        }
        return result;
    }

    public static int superPow(int a, int[] b) {
        a %= M;
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = result * normalPow(a, b[i]) % M;
            a = normalPow(a, 10);
        }
        return result;
    }

}
