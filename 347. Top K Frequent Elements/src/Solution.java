import java.util.*;

public class Solution {

    public static void main(String[] args) {

        final var caseLength = 2;
        final var nums = List.of(new int[]{1, 1, 1, 2, 2, 3}, new int[]{1});
        final var k = List.of(2, 1);
        final var output = List.of(new int[]{1, 2}, new int[]{1});

        for (int i = 0; i < caseLength; i++) {

            final var expected = output.get(i);
            final var myOutput = topKFrequent(nums.get(i), k.get(i));

            if (!Arrays.equals(expected, myOutput)) {
                System.out.println("FAIL");
                System.out.println("Case: " + (i + 1));
                System.out.println("Expected: " + Arrays.toString(expected));
                System.out.println("MyOutput: " + Arrays.toString(myOutput));
            }

        }

        System.out.println("SUCCESS");
    }

    public static int[] topKFrequent(int[] nums, int k) {

        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}

