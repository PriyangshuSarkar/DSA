import java.util.*;

class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] < target) {

        }

        while (left <= right) {
            int mid = (left + right) / 2;

            visualizeSearch(nums, left, mid, right, target);

            if (target == nums[mid]) {
                return mid;
            }
            if (target == nums[left]) {
                return left;
            }
            if (target == nums[right]) {
                return right;
            }

            if (nums[left] <= nums[mid]) {
                if (target < nums[left] || nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || nums[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
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