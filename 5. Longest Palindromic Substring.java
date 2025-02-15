class Solution {

    String result;

    int length = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            checkPalindrom(s, i, i);

            checkPalindrom(s, i, i + 1);
        }

        return result;
    }

    private void checkPalindrom(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if ((r - l + 1) > length) {
                result = s.substring(l, r + 1);
                length = (r - l + 1);
            }
            l--;
            r++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "babad";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.longestPalindrome(s1));
        // Expected Output: "bab" or "aba"

        // Test case 2
        String s2 = "cbbd";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.longestPalindrome(s2));
        // Expected Output: "bb"

        // Test case 3
        String s3 = "a";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.longestPalindrome(s3));
        // Expected Output: "a"

        // Test case 4
        String s4 = "ac";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solution.longestPalindrome(s4));
        // Expected Output: "a" or "c" (single character strings)

        // Test case 5 (Edge case: empty string)
        String s5 = "";
        System.out.println("Input: " + s5);
        System.out.println("Output: " + solution.longestPalindrome(s5));
        // Expected Output: ""
    }
}
