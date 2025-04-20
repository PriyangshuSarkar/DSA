import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop();
                arr[index] = num;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return arr;
    }
}