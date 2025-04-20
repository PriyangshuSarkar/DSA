import java.util.*;

class Solution {

    // public int removeDuplicates(int[] nums) {
    //     Queue<Integer> queue = new LinkedList<>();

    //     int j = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         // System.out.println(queue);
    //         if (!queue.isEmpty() && queue.peek() != nums[i]) {
    //             nums[j] = queue.poll();
    //             j++;
    //             if (!queue.isEmpty() && queue.peek() != nums[i]) {
    //                 nums[j] = queue.poll();
    //                 j++;
    //             }
    //             queue.clear();
    //         }
    //         queue.add(nums[i]);
    //     }

    //     // System.out.println(queue);

    //     while (!queue.isEmpty()) {
    //         // System.out.println(queue);
    //         nums[j] = queue.poll();
    //         j++;
    //     }

    //     return j + 1;
    // }

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int num : nums) {
            // System.out.println(Arrays.toString(nums));
            if (j < 2 || nums[j - 2] != num) {
                nums[j] = num;
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 1, 1, 1, 2, 2, 3 };

        int n = solution.removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(n);
    }
}
