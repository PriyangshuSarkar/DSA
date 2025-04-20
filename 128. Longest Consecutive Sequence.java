import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int result = 0;

        for (int n : nums) {
            if (!set.contains(n - 1)) {

                int temp = 1;

                while (set.contains(n + temp)) {
                    temp++;
                }

                result = Math.max(temp, result);
            }
        }

        return result;

    }
}