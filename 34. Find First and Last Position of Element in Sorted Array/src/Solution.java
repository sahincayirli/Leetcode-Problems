import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        System.out.println(binarySearch(new int[]{5, 7, 8, 8, 8, 10}, 8));



    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        int left = 0 , right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (target > nums[mid]) {
                left = mid + 1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                return null;
            }
        }

        return null;
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        int mid = left;

        while (left < right) {

            if (target > nums[mid]) {
                left = mid + 1;
            }
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                return mid;
            }
            mid = left + (right - left) / 2;

        }
        return -1;
    }

}
