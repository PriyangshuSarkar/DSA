import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        backtrack(result, digits, 0, new StringBuilder());

        return result;

    }

    private void backtrack(List<String> result, String digits, int index, StringBuilder cur) {

        if (index == digits.length()) {
            result.add(new String(cur));
            return;
        }

        char[] charArr = t9(digits.charAt(index) - '0');

        for (char c : charArr) {
            cur.append(c);
            backtrack(result, digits, index + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }

    }

    public char[] t9(int n) {
        switch (n) {
            case 2:
                return new char[] { 'a', 'b', 'c' };
            case 3:
                return new char[] { 'd', 'e', 'f' };
            case 4:
                return new char[] { 'g', 'h', 'i' };
            case 5:
                return new char[] { 'j', 'k', 'l' };
            case 6:
                return new char[] { 'm', 'n', 'o' };
            case 7:
                return new char[] { 'p', 'q', 'r', 's' };
            case 8:
                return new char[] { 't', 'u', 'v' };
            case 9:
                return new char[] { 'w', 'x', 'y', 'z' };
            case 0:
                return new char[] { ' ' };
            default:
                return new char[] {};
        }
    }
}