
class Solution {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        int sub = 1;
        for (int i = 1; i <= n; i++) {

            if (sub * 2 == i) {
                sub = i;
            }
            result[i] = result[i - sub] + 1;

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;

        int[] result = solution.countBits(n);

        for (int i : result) {
            System.err.println(i);
        }
    }
}
