import java.util.List;

public class Solution {

    public static void main(String[] args) {

        final var caseLength = 2;

        final var nums = List.of(new int[] {2,3,1,1,4}, new int[] {3,2,1,0,4});
        final var output = List.of(true,false);

        for (int i = 0; i < caseLength; i++) {
            System.out.println(canJump(nums.get(i)));
        }

    }

    public static boolean canJump(int[] nums) {

        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}
