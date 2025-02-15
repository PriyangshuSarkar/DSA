
class Solution {

    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;

            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solve = new Solution();

        int a = 1000032;
        int b = 12378826;

        System.err.println(a + "+" + b + "=" + solve.getSum(a, b));

    }
}
