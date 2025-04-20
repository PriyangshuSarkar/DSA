import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temp) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] t = { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(Arrays.toString(solution.dailyTemperatures(t)));

    }
}