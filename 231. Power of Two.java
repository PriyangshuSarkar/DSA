class Solution {
    public boolean isPowerOfTwo(int n) {
        System.out.println(16 & 15);
        return (n > 0 && (n & (n - 1)) == 0) ? true : false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result = solution.isPowerOfTwo(16);

        System.out.println(result);
    }
}