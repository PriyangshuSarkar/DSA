class Solution {
    public int maxSubArray(int[] nums) {

        int j = 0;
        int l = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (j < l) {
            sum += nums[j];

            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }

            j++;

        }

        return max;
    }
}