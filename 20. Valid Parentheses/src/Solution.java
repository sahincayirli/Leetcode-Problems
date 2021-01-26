import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    private static Map<Character, Character> map = Map.of('[', ']', '(', ')', '{', '}');

    public static void main(String[] args) {

        final var caseLength = 5;
        final var s = List.of("()", "()[]{}", "(]", "([)]", "{[]}");
        final var output = List.of(true, true, false, false, true);

        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = isValid(s.get(i));

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

    public static boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                if (c != map.get(stack.peek()))
                    return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
