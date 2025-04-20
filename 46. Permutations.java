import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);

        return result;

    }

    public void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {

        if (list.size() >= nums.length) {
            result.add(new ArrayList<>(list));

            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            used[i] = true;
            list.add(nums[i]);

            System.out.println(list.toString());
            System.out.println(Arrays.toString(used));

            backtrack(result, list, nums, used);

            list.removeLast();
            used[i] = false;

            // System.out.println(list.toString());
            // System.out.println(Arrays.toString(used));

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] n = new int[] { 1, 2, 3 };
        System.out.println(solution.permute(n));
    }
}