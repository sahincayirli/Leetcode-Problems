import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Objects.requireNonNull(threeSum(new int[]{0, 0, 0, 0})).forEach(System.out::println);

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {


                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) ++left;
                        while (left < right && nums[right] == nums[right - 1]) --right;

                        ++left;
                        --right;
                    }
                    else if (sum > target) {
                        --right;
                    }
                    else {
                        ++left;
                    }

                }
            }

        }

        return result;
    }

}
