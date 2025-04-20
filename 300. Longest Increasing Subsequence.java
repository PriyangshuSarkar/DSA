
import java.util.*;

class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums, 0, -1, dp);
    }

    public int helper(int[] nums, int curr, int prev, int[][] dp) {
        if (curr == nums.length) {
            return 0;
        }

        if (dp[curr][prev + 1] != -1) {
            return dp[curr][prev + 1];
        }

        int length = helper(nums, curr + 1, prev, dp);

        if (prev == -1 || nums[curr] > nums[prev]) {
            length = Math.max(length, 1 + helper(nums, curr + 1, curr, dp));
        }

        dp[curr][prev + 1] = length;

        return length;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 12, 45, 78, 23, 56, 89, 101, 34, 67, 90, 11, 43, 76, 29, 54, 87, 98, 32, 65, 88, 15, 47, 79, 26,
                59, 91, 102, 36, 69, 92, 18, 50, 83, 22, 55, 86, 99, 31, 63, 85, 14, 42, 75, 28, 53, 84, 97, 30, 61, 82,
                10, 41, 74, 25, 52, 81, 95, 27, 60, 80, 13, 44, 77, 21, 57, 88, 100, 33, 68, 93, 17, 49, 82, 24, 58, 85,
                96, 35, 64, 89, 19, 51, 73, 20, 56, 78, 94, 37, 66, 87, 16, 46, 70, 39, 62, 72, 103, 40, 71, 104 };
        System.out.printf("Result for %s: %d%n", Arrays.toString(nums), solution.lengthOfLIS(nums));
    }
}
