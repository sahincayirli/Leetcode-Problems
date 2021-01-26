import java.util.List;

public class Solution {

    public static boolean detectCapitalUse(String word) {
        return isAllLower(word) || isAllUpper(word) || isCapital(word);
    }

    private static boolean isAllUpper(String word) {
        return word.chars().allMatch(i -> Character.isUpperCase(i));
    }

    private static boolean isAllLower(String word) {
        return word.chars().allMatch(i -> Character.isLowerCase(i));
    }

    private static boolean isCapital(String word) {
        return Character.isUpperCase(word.charAt(0)) && isAllLower(word.substring(1));
    }

    // clear but slow
    public static boolean best(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    public static void main(String[] args) {

        var caseLength = 2;
        var word = List.of("USA", "FlaG");
        var result = List.of(true, false);

        for (int i = 0; i < caseLength; i++) {
            if (result.get(i) != best(word.get(i))) {
                System.out.println("FAIL");
                System.out.println("CASE : " + (i + 1));
                return;
            }
        }

        System.out.println("SUCCESS");

    }

}
