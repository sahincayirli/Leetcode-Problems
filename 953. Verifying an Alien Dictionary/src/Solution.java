import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static boolean isAlienSorted(String[] words, String order) {

        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }

            // If we didn't find a first difference, the
            // words are like ("app", "apple").
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        final var caseLength = 3;
        final var words = List.of(new String[]{"hello", "leetcode"}, new String[]{"word", "world", "row"}, new String[]{"apple", "app"});
        final var order = List.of("hlabcdefgijkmnopqrstuvwxyz", "worldabcefghijkmnpqstuvxyz", "abcdefghijklmnopqrstuvwxyz");
        final var output = List.of(true, false, false);
        for (int i = 0; i < caseLength; i++) {
            final var expected = output.get(i);
            final var myOutput = isAlienSorted(words.get(i), order.get(i));

            if (expected != myOutput) {
                System.out.println("FAIL");
                System.out.println("Case: " + (i + 1));
                return;
            }
        }

        System.out.println("SUCCESS");

    }

}
