public class Solution {

    public static void main(String[] args) {

        System.out.print("Expected: " + "bab ");
        System.out.println("My Output: " + longestPalindrome("babad"));
        System.out.println("--------------------------");
        System.out.print("Expected: " + "bb ");
        System.out.println("My Output: " + longestPalindrome("cbbd"));
        System.out.println("--------------------------");
        System.out.print("Expected: " + "a ");
        System.out.println("My Output: " + longestPalindrome("a"));
        System.out.println("--------------------------");
        System.out.print("Expected: " + "a ");
        System.out.println("My Output: " + longestPalindrome("ac"));
        System.out.println("--------------------------");


    }

    public static String longestPalindrome(String s) {

        String result = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                int currLen = right - left + 1;
                if (currLen > resLen) {
                    resLen = currLen;
                    result = s.substring(left,right+1);
                }

                --left;
                ++right;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                int currLen = right - left + 1;
                if (currLen > resLen) {
                    resLen = currLen;
                    result = s.substring(left,right+1);
                }

                --left;
                ++right;
            }
        }

        return result;
    }

}
