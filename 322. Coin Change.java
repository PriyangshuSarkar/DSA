
import java.util.*;

class Solution {

    // public int coinChange(int[] coins, int amount) {
    //     int[] memo = new int[amount + 1];
    //     Arrays.fill(memo, -1);
    //     int result = helper(coins, amount, memo);
    //     return (result != Integer.MAX_VALUE) ? result : -1;
    // }
    // public int helper(int[] coins, int amount, int[] memo) {
    //     if (amount == 0) {
    //         return 0;
    //     }
    //     if (amount < 0) {
    //         return Integer.MAX_VALUE;
    //     }
    //     if (memo[amount] != -1) {
    //         return memo[amount];
    //     }
    //     int minCoins = Integer.MAX_VALUE;
    //     for (int coin : coins) {
    //         int result = helper(coins, amount - coin, memo);
    //         if (result != Integer.MAX_VALUE) {
    //             minCoins = Math.min(minCoins, result + 1);
    //         }
    //     }
    //     memo[amount] = minCoins;
    //     return minCoins;
    // }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with an unreachable value
        dp[0] = 0; // Base case: 0 coins for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5};
        int n = 9999;

        Solution solve = new Solution();

        System.out.println("Number of Jumps for " + n + " : " + solve.coinChange(nums, n));

    }
}
