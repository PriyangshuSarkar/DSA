import java.util.*;

class Solution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharsRemaining = t.length();
        int[] minWindow = { 0, Integer.MAX_VALUE };
        int startIndex = 0;

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);

            // Update the character count for the current window
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            // If the character is part of t and it's still required, decrement targetCharsRemaining
            if (charCount.containsKey(ch) && charCount.get(ch) >= 0) {
                targetCharsRemaining--;
            }

            // When the window satisfies all characters of t
            if (targetCharsRemaining == 0) {
                // Shrink the window from the left
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (
                        charCount.containsKey(charAtStart) &&
                        charCount.get(charAtStart) == 0
                    ) {
                        break;
                    }
                    charCount.put(
                        charAtStart,
                        charCount.getOrDefault(charAtStart, 0) + 1
                    );
                    startIndex++;
                }

                // Update the result if a smaller window is found
                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                // Restore the character count and move the startIndex to shrink the window
                charCount.put(
                    s.charAt(startIndex),
                    charCount.getOrDefault(s.charAt(startIndex), 0) + 1
                );
                targetCharsRemaining++;
                startIndex++;
            }
        }

        return minWindow[1] >= s.length()
            ? ""
            : s.substring(minWindow[0], minWindow[1] + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s = " + s1 + ", t = " + t1);
        System.out.println("Output: " + solution.minWindow(s1, t1));
        // Expected Output: "BANC"

        // Test case 2
        String s2 = "AA";
        String t2 = "AA";
        System.out.println("Input: s = " + s2 + ", t = " + t2);
        System.out.println("Output: " + solution.minWindow(s2, t2));
        // Expected Output: "AA"

        // Test case 3
        String s3 = "ADOBECODEBANC";
        String t3 = "ABCD";
        System.out.println("Input: s = " + s3 + ", t = " + t3);
        System.out.println("Output: " + solution.minWindow(s3, t3));
        // Expected Output: "ADOBEC"

        // Test case 4
        String s4 = "A";
        String t4 = "AA";
        System.out.println("Input: s = " + s4 + ", t = " + t4);
        System.out.println("Output: " + solution.minWindow(s4, t4));
        // Expected Output: ""

        // Test case 5 (Edge case: empty string for s or t)
        String s5 = "";
        String t5 = "A";
        System.out.println("Input: s = " + s5 + ", t = " + t5);
        System.out.println("Output: " + solution.minWindow(s5, t5));
        // Expected Output: ""
    }
}
