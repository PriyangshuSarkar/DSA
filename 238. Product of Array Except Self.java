import java.util.*;

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.fill(arr, 1);

        int curr = 1;
        for (int i = 0; i < n; i++) {
            arr[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] *= curr;
            curr *= nums[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println(
            "Output: " + Arrays.toString(solution.productExceptSelf(nums1))
        );
        // Expected Output: [24, 12, 8, 6]

        // Test case 2
        int[] nums2 = { -1, 1, 0, -3, 3 };
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println(
            "Output: " + Arrays.toString(solution.productExceptSelf(nums2))
        );
        // Expected Output: [0, 0, 9, 0, 0]

        // Test case 3
        int[] nums3 = { 2, 3 };
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println(
            "Output: " + Arrays.toString(solution.productExceptSelf(nums3))
        );
        // Expected Output: [3, 2]

        // Test case 4
        int[] nums4 = { 1 };
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println(
            "Output: " + Arrays.toString(solution.productExceptSelf(nums4))
        );
        // Edge Case Output: [1] (not applicable in LeetCode constraints, but for testing)
    }
}
