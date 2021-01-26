import java.util.Arrays;
import java.util.List;

public class Solution {

    // best solution
    public static int best(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8
            //            ^
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1]) end = mid;

                // We found a pair. The single element must be on the right.
                // Example: |1 1 3 3 5 6 6|
                //               ^ ^
                // Next:     1 1 3 3|5 6 6|
            else start = mid + 2;
        }

        // 'start' should always be at the beginning of a pair.
        // When 'start > end', start must be the single element.
        return nums[start];
    }

    // my solution
    public static int singleNonDuplicate(int[] nums) {

        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            int index = Arrays.binarySearch(nums, key);
            if (index == 0 && nums[index + 1] != key)
                return key;
            if (index == nums.length - 1 && nums[index - 1] != key)
                return key;
            if (index != 0 && index != nums.length - 1 && nums[index - 1] != key && nums[index + 1] != key)
                return key;
        }

        return -1;

    }

    public static void main(String[] args) {


        var caseLength = 2;
        var nums = List.of(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, new int[]{3, 3, 7, 7, 10, 11, 11});
        var result = List.of(2, 10);

        for (int i = 0; i < caseLength; i++) {
            if (result.get(i) != singleNonDuplicate(nums.get(i))) {
                System.out.println("FAIL");
                return;
            }
        }

        System.out.println("SUCCESS");


    }

}
