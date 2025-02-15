
class Solution {

    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            int temp = n % 2;
            n = n / 2;

            if (temp != 0) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 128;
        System.err.println(solution.hammingWeight(n));
    }
}
