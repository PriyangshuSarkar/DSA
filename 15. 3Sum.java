import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (0 < sum) {
                    k--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1])
                        j++;

                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] n = { -1, 0, 1, 2, -1, -4 };

        System.out.println((solution.threeSum(n)).toString());
    }
}