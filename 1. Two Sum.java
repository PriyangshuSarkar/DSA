import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 3, 2, 4 };

        int target = 6;

        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}