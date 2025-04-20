class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int odd = 0;
        int l = 0, m = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 != 0) {
                odd++;
                m = l;
            }

            while (k < odd) {
                if (nums[l] % 2 != 0) {
                    odd--;
                }

                l++;
                m = l;
            }

            if (odd == k) {
                while (nums[m] % 2 == 0) {
                    m++;
                }

                res += m - l + 1;
            }
        }

        return res;

    }
}