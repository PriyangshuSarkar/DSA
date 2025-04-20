import java.util.*;

class Solution {

    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        Arrays.sort(coins);
        reverse(coins);

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        int result = recursion(coins, amount, memo);
        return (result == Integer.MAX_VALUE) ? -1 : result;

    }

    public int iteration(int[] coins, int amount, int[] memo) {
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }

        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

    public int recursion(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (memo[amount] != -1)
            return memo[amount];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = recursion(coins, amount - coin, memo);

            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        memo[amount] = minCoins;

        return minCoins;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5 };
        int n = 11;

        Solution solve = new Solution();

        System.out.println(
                "Number of Jumps for " + n + " : " + solve.coinChange(nums, n));
    }
}
