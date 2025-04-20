
class Solution {
    public int singleNumber(int[] nums) {
        int xorr = 0;
        for (int i = 0; i < nums.length; i++) {
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 4, 1, 2, 1, 2 };

        System.out.println(solution.singleNumber(nums));
    }
}