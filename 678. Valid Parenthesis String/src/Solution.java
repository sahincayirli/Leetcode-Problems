import java.util.List;
import java.util.Stack;

public class Solution {

    // best solution
    public static boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;


    }


    public static void main(String[] args) {

        if (true) {
            var caseLength = 4;
            var s = List.of("()", "(*)", "(*))", "(())((())()()(*)(*()(())())())()()((()())((()))(*");
            var result = List.of(true, true, true, false);

            for (int i = 0; i < caseLength; i++) {
                var ans = checkValidString(s.get(i));
                if (result.get(i) != ans) {
                    System.out.println("FAIL");
                    System.out.println("Case : " + i);
                    return;
                }
            }

            System.out.println("SUCCESS");
        }


    }

}
