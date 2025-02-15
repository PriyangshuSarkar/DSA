import java.util.*;

class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 1, 1, 1 };
        int k1 = 2;
        System.out.println(
            "Count of subarrays with sum " +
            k1 +
            ": " +
            solution.subarraySum(nums1, k1)
        );
        // Expected Output: 2

        // Test case 2
        int[] nums2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println(
            "Count of subarrays with sum " +
            k2 +
            ": " +
            solution.subarraySum(nums2, k2)
        );
        // Expected Output: 2

        // Test case 3
        int[] nums3 = { 1, -1, 1, 2, -1 };
        int k3 = 2;
        System.out.println(
            "Count of subarrays with sum " +
            k3 +
            ": " +
            solution.subarraySum(nums3, k3)
        );
        // Expected Output: 3

        // Test case 4
        int[] nums4 = { 0, 0, 0 };
        int k4 = 0;
        System.out.println(
            "Count of subarrays with sum " +
            k4 +
            ": " +
            solution.subarraySum(nums4, k4)
        );
        // Expected Output: 6
    }
}
