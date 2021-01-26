import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        final var caseLength = 4;
        final var s = List.of("3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz");
        final var output = List.of("aaabcbc", "accaccacc", "abcabccdcdcdef", "abccdcdcdxyz");

        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = decodeString(s.get(i));

            if (!expected.equals(myOutput)) {
                System.out.println("FAIL");
                System.out.println("Case: " + (i + 1));
                System.out.println("Expected: " + expected);
                System.out.println("MyOutput: " + myOutput);
                return;
            }
        }

        System.out.println("SUCCESS");





    }

    public static String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ']') {

                for (int j = sb.length() - 1; j >= 0; j--) {
                    char csb = sb.charAt(j);
                    if (Character.isDigit(csb)) {
                        StringBuilder num = new StringBuilder();
                        while (j != 0 && Character.isDigit(sb.charAt(j--))) num.append(sb.charAt(j+1));

                        String repeated = sb.substring(j + 1).repeat(Integer.parseInt(num.reverse().toString()));
                        sb.delete(j, sb.length());
                        sb.append(repeated);
                        break;
                    }
                }

            } else if (Character.isLetterOrDigit(c)){
                sb.append(c);
            }

        }

        return sb.toString();
    }
}
