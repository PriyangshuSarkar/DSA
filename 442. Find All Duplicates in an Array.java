import java.util.*;

class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        // HashSet<Integer> set = new HashSet<>();

        // for (int n : nums) {
        // if (set.contains(n)) {
        // list.add(n);
        // } else {
        // set.add(n);
        // }
        // }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Test case 1: " + solution.findDuplicates(nums1));
        // Expected Output: [2, 3]

        // Test case 2
        int[] nums2 = { 1, 1, 2 };
        System.out.println("Test case 2: " + solution.findDuplicates(nums2));
        // Expected Output: [1]

        // Test case 3
        int[] nums3 = { 1 };
        System.out.println("Test case 3: " + solution.findDuplicates(nums3));
        // Expected Output: []

        // Test case 4
        int[] nums4 = { 1, 2, 3, 4, 5 };
        System.out.println("Test case 4: " + solution.findDuplicates(nums4));
        // Expected Output: []

        // Test case 5: All elements are the same
        int[] nums5 = { 3, 3, 3, 3, 3 };
        System.out.println("Test case 5: " + solution.findDuplicates(nums5));
        // Expected Output: [3]
    }
}
