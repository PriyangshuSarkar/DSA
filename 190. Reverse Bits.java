
class Solution {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1); // Shift left, add last bit of n
            n >>>= 1;  // Unsigned right shift (avoids sign extension)
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 0b00000010100101000001111010011100;
        Solution solution = new Solution();
        System.out.println(solution.reverseBits(n)); // Output: 964176192
    }
}
