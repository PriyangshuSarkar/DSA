class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0;
        int j = 0;

        while (i < nums.length && j < nums.length) {

            if (j < i) {
                j++;
            }

            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }

            if (nums[i] != 0) {
                i++;
            }
            if (nums[j] == 0) {
                j++;
            }

        }

        return;

    }
}