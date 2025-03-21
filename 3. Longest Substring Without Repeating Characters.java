import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;

        HashSet<Character> set = new HashSet<>();

        int n = s.length();
        int i = 0;
        int j = 0;

        while (i <= j && i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
            }
            result = Math.max((j - i), result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abcabcbb";

        System.err.println(solution.lengthOfLongestSubstring(s));
    }
}