class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Test case 1: " + solution.maxProfit(prices1));
        // Expected Output: 7 (buy at 1, sell at 5, buy at 3, sell at 6)

        // Test case 2
        int[] prices2 = { 1, 2, 3, 4, 5 };
        System.out.println("Test case 2: " + solution.maxProfit(prices2));
        // Expected Output: 4 (buy at 1, sell at 5)

        // Test case 3
        int[] prices3 = { 7, 6, 4, 3, 1 };
        System.out.println("Test case 3: " + solution.maxProfit(prices3));
        // Expected Output: 0 (no profit, prices are decreasing)

        // Test case 4
        int[] prices4 = { 3, 2, 6, 5, 0, 3 };
        System.out.println("Test case 4: " + solution.maxProfit(prices4));
        // Expected Output: 7 (buy at 2, sell at 6, buy at 0, sell at 3)
    }
}
