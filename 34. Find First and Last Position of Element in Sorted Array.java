import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int temp = -1;

        while (l <= r) {

            int m = (l + r) / 2;

            visualizeSearch(nums, l, m, r, target);

            if (nums[m] == target) {
                temp = m;
                break;
            }
            if (nums[l] == target) {
                temp = l;
                break;
            }
            if (nums[r] == target) {
                temp = r;
                break;
            }

            if (target < nums[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        int first = temp;
        int last = temp;

        while ((0 <= first - 1 && nums[first - 1] == target) || (last + 1 < nums.length && nums[last + 1] == target)) {
            if (0 <= first - 1 && nums[first - 1] == target) {
                first--;
            }
            if (last + 1 < nums.length && nums[last + 1] == target) {
                last++;
            }
        }

        return new int[] { first, last };
    }

    private void visualizeSearch(int[] nums, int left, int mid, int right, int target) {
        System.out.println("\nArray: " + Arrays.toString(nums));
        System.out.println(
                "\nLeft: " + nums[left] + " | Mid: " + nums[mid] + " | Right: " + nums[right] + " | Target: " + target);
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 2, 2 };
        int target = 2;

        int[] result = solution.searchRange(nums, target);
        System.out.println("\nTarget " + target + " found at index: " + Arrays.toString(result));
    }
}