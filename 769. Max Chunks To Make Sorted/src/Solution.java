import java.util.List;

public class Solution {

    public static int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

        var caseLength = 2;
        var arr = List.of(new int[] {4,3,2,1,0}, new int[] {1,0,2,3,4});
        var result = List.of(1,4);

        for (int i = 0; i < caseLength; i++) {
            if (result.get(i) != maxChunksToSorted(arr.get(i))) {
                System.out.println("FAIL");
                System.out.println("CASE : " + (i + 1));
                return;
            }
        }

        System.out.println("SUCCESS");

    }

}
