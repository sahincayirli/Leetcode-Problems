import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        int res = lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);

    }

    public static int lengthOfLongestSubstring(String s) {

        int firstPointer = 0;
        int secondPointer = 0;
        int max = 0;

        Set<Character> window = new HashSet<>();

        while (secondPointer < s.length()) {
            char cSecond = s.charAt(secondPointer);

            if (!window.contains(cSecond)) {
                window.add(cSecond);
                ++secondPointer;
                max = Math.max(max, window.size());
            }
            else {
                window.remove(s.charAt(firstPointer));
                ++firstPointer;
            }

        }
        return max;
    }

}
