import java.util.*;

class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int maxValue = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 3, 2, 3 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.majorityElement(nums1));
        // Expected Output: 3

        // Test case 2
        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.majorityElement(nums2));
        // Expected Output: 2

        // Test case 3
        int[] nums3 = { 1 };
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.majorityElement(nums3));
        // Expected Output: 1

        // Test case 4
        int[] nums4 = { 1, 1, 2, 2, 2 };
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + solution.majorityElement(nums4));
        // Expected Output: 2

        // Test case 5 (Edge case: all elements are the same)
        int[] nums5 = { 5, 5, 5, 5, 5 };
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Output: " + solution.majorityElement(nums5));
        // Expected Output: 5
    }
}
