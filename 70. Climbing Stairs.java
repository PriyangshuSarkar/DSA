
class Solution {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    public int helper(int n, int[] memo) {

        if (n <= 1) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Solution solve = new Solution();

        int[] num = {2, 3};

        for (int n : num) {

            System.out.println("Number of Jumps for " + n + " : " + solve.climbStairs(n));
        }
    }
}
