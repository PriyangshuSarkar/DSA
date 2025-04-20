import java.util.*;

class Solution {
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            visualizeSearch(nums, l, m, r, target);

            if (nums[m] == target) {
                return m;
            }
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }

            if (nums[l] <= nums[m]) {
                if (target < nums[l] || nums[m] < target) {

                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (target < nums[m] || nums[r] < target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }

        return -1;

    }

    private void visualizeSearch(int[] nums, int left, int mid, int right, int target) {
        System.out.println("\nArray: " + Arrays.toString(nums));
        System.out.println(
                "\nLeft: " + nums[left] + " | Mid: " + nums[mid] + " | Right: " + nums[right] + " | Target: " + target);
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 30, 35, 40, 45, 50, 55, 5, 10, 15, 20, 25 };
        int target = 10;

        int result = solution.search(nums, target);
        System.out.println("\nTarget " + target + " found at index: " + result);
    }
}