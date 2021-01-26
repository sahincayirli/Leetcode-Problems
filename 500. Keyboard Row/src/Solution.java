import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {

    // elegant solution
    public static String[] findWordsTwo(String[] words) {
        return Stream.of(words).filter(word -> word.matches("[qwertyuiopQWERTYUIOP]+|[asdfghjklASDFGHJKL]+|[zxcvbnmZXCVBNM]+")).toArray(String[]::new);
    }


    // my solution
    public static String[] findWords(String[] words) {

        var pattern = "[qwertyuiopQWERTYUIOP]+|[asdfghjklASDFGHJKL]+|[zxcvbnmZXCVBNM]+";

        var list = new LinkedList<String>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].matches(pattern)) {
                list.add(words[i]);
            }
        }

        return list.toArray(String[]::new);
    }

    public static void main(String[] args) {

        var input = new String[] {"Hello", "Alaska", "Dad", "Peace"};
        var output = new String[] {"Alaska", "Dad"};

        var testResult = findWordsTwo(input);

        for (int i = 0; i < output.length; i++) {
            if (!output[i].equals(testResult[i])) {
                System.out.println("FAIL");
                return;
            }
        }

        System.out.println("SUCCESS");
    }

}
