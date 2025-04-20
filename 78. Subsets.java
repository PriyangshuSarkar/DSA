import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums, 0);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {

        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {

            list.add(nums[i]);

            backtrack(result, list, nums, i + 1);

            list.removeLast();

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] n = new int[] { 1, 2, 3 };
        System.out.println(solution.subsets(n));
    }
}