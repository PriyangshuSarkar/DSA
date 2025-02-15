
import java.util.*;

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int n = numbers.length;
        if (n < 2) {
            return result;
        }

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 2;

                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println(Arrays.toString(result1));
        // Expected output: [1, 2]

        // Test case 2
        int[] numbers2 = {1, 2, 3, 4, 5};
        int target2 = 9;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println(Arrays.toString(result2));
        // Expected output: [4, 5]

        // Test case 3
        int[] numbers3 = {1, 3, 5, 7, 9};
        int target3 = 10;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println(Arrays.toString(result3));
        // Expected output: [1, 5]

        // Test case 4
        int[] numbers4 = {3, 4, 6, 8, 10};
        int target4 = 14;
        int[] result4 = solution.twoSum(numbers4, target4);
        System.out.println(Arrays.toString(result4));
        // Expected output: [3, 5]
    }
}
