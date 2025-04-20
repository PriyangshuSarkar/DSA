import java.util.*;

class Solution {
    public void rotate(int[][] mat) {

        int left = 0;
        int right = mat[0].length - 1;

        while (left < right) {
            for (int i = 0; i < (right - left); i++) {

                int top = left;
                int bottom = right;

                int topLeft = mat[top][left + i];

                mat[top][left + i] = mat[bottom - i][left];

                mat[bottom - i][left] = mat[bottom][right - i];

                mat[bottom][right - i] = mat[top + i][right];

                mat[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        solution.rotate(mat);

        System.out.println(Arrays.deepToString(mat));
    }
}