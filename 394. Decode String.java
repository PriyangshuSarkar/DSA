import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(currentString);

                num = 0;
                currentString = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = countStack.pop();

                StringBuilder decodedPart = stringStack.pop();
                while (repeatTimes > 0) {
                    decodedPart.append(currentString);
                    repeatTimes--;
                }
                currentString = decodedPart;
            } else {
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
