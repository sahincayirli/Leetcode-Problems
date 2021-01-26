import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static boolean isIsomorphic(String s1, String s2) {

        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;

    }

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        if (isIsomorphic(s,t))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

}
