import java.util.*;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int n : arr) {
            map.put(n, map.getOrDefault((n - difference), 0) + 1);
            maxLength = Math.max(maxLength, map.get(n));
        }

        return maxLength;

    }
}