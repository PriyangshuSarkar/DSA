import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();

            Arrays.sort(chars);

            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Test case 1: " + solution.groupAnagrams(strs1));
        // Expected Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

        // Test case 2
        String[] strs2 = { "" };
        System.out.println("Test case 2: " + solution.groupAnagrams(strs2));
        // Expected Output: [[""]]

        // Test case 3
        String[] strs3 = { "a" };
        System.out.println("Test case 3: " + solution.groupAnagrams(strs3));
        // Expected Output: [["a"]]

        // Test case 4
        String[] strs4 = { "abc", "acb", "bac", "xyz", "zyx" };
        System.out.println("Test case 4: " + solution.groupAnagrams(strs4));
        // Expected Output: [["abc", "acb", "bac"], ["xyz", "zyx"]]

        // Test case 5: No anagrams
        String[] strs5 = { "hello", "world", "java" };
        System.out.println("Test case 5: " + solution.groupAnagrams(strs5));
        // Expected Output: [["hello"], ["world"], ["java"]]
    }
}
