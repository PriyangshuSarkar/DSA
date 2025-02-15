
import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = solution.threeSum(nums1);
        System.out.println(result1);
        // Expected output: [[-1, -1, 2], [-1, 0, 1]]

        // Test case 2
        int[] nums2 = {0, 0, 0};
        List<List<Integer>> result2 = solution.threeSum(nums2);
        System.out.println(result2);
        // Expected output: [[0, 0, 0]]

        // Test case 3
        int[] nums3 = {1, 2, -2, -1};
        List<List<Integer>> result3 = solution.threeSum(nums3);
        System.out.println(result3);
        // Expected output: []

        // Test case 4
        int[] nums4 = {3, -2, 1, 0};
        List<List<Integer>> result4 = solution.threeSum(nums4);
        System.out.println(result4);
        // Expected output: []
    }

    // Helper method to print the list of lists
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
