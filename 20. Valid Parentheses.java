import java.util.*;

class Solution {
    public boolean isValid(String s) {

        if (s == "") {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}