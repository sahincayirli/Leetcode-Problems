import java.util.*;

public class Solution {

    public static boolean wordPattern(String pattern, String s) {
        var map = new HashMap<>();
        var words = s.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i),i), map.put(words[i],i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        var lengthOfCases = 4;
        var pattern = List.of("abba","abba","aaaa","abba");
        var s = List.of("dog cat cat dog","dog cat cat fish","dog cat cat dog","dog dog dog dog");
        var result = List.of(true,false,false,false);

        for (int i = 0; i < lengthOfCases; i++) {
            if (result.get(i) != wordPattern(pattern.get(i),s.get(i))) {
                System.out.println("FAIL");
                return;
            }
        }

        System.out.println("SUCCESS");
    }


}
