import java.util.List;

public class Solution {

    //best solution
    public static String decodeAtIndexBest(String S, int K) {
        long curLength = 0;
        char c = 0;

        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                curLength *= c - '0';
            }
            else {
                curLength++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                curLength /= c - '0';
                K %= curLength;
            }
            else {
                if (K == 0 || K == curLength) {
                    return "" + c;
                }
                curLength--;
            }
        }

        throw null;
    }

    // my solution
    public static String decodeAtIndex(String S, int K) {
        if (K == 1) return String.valueOf(S.charAt(K - 1));
        return String.valueOf(helper(S).charAt(K - 1));
    }

    public static String helper(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                fastRepeat(sb,sb.toString(),c - 49);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void fastRepeat(StringBuilder sb, String s, int n) {
        for (int i = 0; i < n; i++)
            sb.append(s);
    }

    public static void main(String[] args) {

        var caseLength = 3;
        var s = List.of("leet2code3", "ha22", "a2345678999999999999999");
        var K = List.of(10, 5, 1);
        var result = List.of("o", "h", "a");

        for (int i = 0; i < caseLength; i++) {
            if (!result.get(i).equals(decodeAtIndex(s.get(i), K.get(i)))) {
                System.out.println("FAIL");
                return;
            }
        }

        System.out.println("SUCCESS");
        System.out.println(decodeAtIndexBest("y959q969u3hb22odq595", 222280369));

    }

}
