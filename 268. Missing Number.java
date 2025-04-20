class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;

        int l = nums.length;

        for (int i = 0; i < l; i++) {
            result = result ^ i;
            result = result ^ nums[i];

            System.out.println(result);
        }

        result = result ^ l;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 0, 1 };

        System.out.println(solution.missingNumber(nums));
    }
}