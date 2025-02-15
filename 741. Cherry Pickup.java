// class Solution {

//     int maxCherryCollected = 0;
//     public int cherryPickup(int[][] grid) {
//         int cherries = 0;
//         backtrack(grid, 0, 0, cherries);
//         return maxCherryCollected;
//     }
//     public void backtrack(int[][] grid, int r, int c, int cherries) {
//         if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
//             return;
//         }
//         int cherry = grid[r][c];
//         grid[r][c] = 0;
//         if (r == grid.length - 1 && c == grid[0].length - 1) {
//             trackback(grid, r, c, cherries + cherry);
//         }
//         backtrack(grid, r + 1, c, cherries + cherry);
//         backtrack(grid, r, c + 1, cherries + cherry);
//         grid[r][c] = cherry;
//     }
//     public void trackback(int[][] grid, int r, int c, int cherries) {
//         if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1) {
//             return;
//         }
//         int cherry = grid[r][c];
//         grid[r][c] = 0;
//         if (r == 0 && c == 0) {
//             maxCherryCollected = Math.max(maxCherryCollected, cherries + cherry);
//             return;
//         }
//         trackback(grid, r - 1, c, cherries + cherry);
//         trackback(grid, r, c - 1, cherries + cherry);
//         grid[r][c] = cherry;
//     }
//     public static void main(String[] args) {
//         int[][] grid = new int[][] {
//                 { 0, 1, -1 },
//                 { 1, 0, -1 },
//                 { 1, 1, 1 }
//         };
//         Solution solve = new Solution();
//         System.out.println("Max Cherries: " + solve.cherryPickup(grid));
//     }
// }
// import java.util.*;
// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int l1 = grid.length;
//         int l2 = grid[0].length;
//         int[][][][] dp = new int[l1][l2][l1][l2];
//         for (int[][][] arr3D : dp) {
//             for (int[][] arr2D : arr3D) {
//                 for (int[] arr : arr2D) {
//                     Arrays.fill(arr, -1);
//                 }
//             }
//         }
//         int result = dfs(grid, l1, l2, 0, 0, 0, 0, dp);
//         return (result >= 0) ? result : 0;
//     }
//     public int dfs(int[][] grid, int l1, int l2, int r1, int c1, int r2, int c2, int[][][][] dp) {
//         if (r1 < 0 || r2 < 0 || c1 < 0 || c2 < 0 ||
//                 r1 >= l1 || r2 >= l1 ||
//                 c1 >= l2 || c2 >= l2 ||
//                 grid[r1][c1] == -1 || grid[r2][c2] == -1) {
//             return Integer.MIN_VALUE;
//         }
//         if (dp[r1][c1][r2][c2] != -1) {
//             return dp[r1][c1][r2][c2];
//         }
//         if (r1 == l1 - 1 && c1 == l2 - 1) {
//             return grid[r1][c1];
//         }
//         int cherries = 0;
//         if (r1 == r2 && c1 == c2) {
//             cherries += (grid[r1][c1] | grid[r2][c2]);
//         } else {
//             cherries += (grid[r1][c1] + grid[r2][c2]);
//         }
//         int f1 = dfs(grid, l1, l2, r1 + 1, c1 + 0, r2 + 1, c2 + 0, dp);
//         int f2 = dfs(grid, l1, l2, r1 + 1, c1 + 0, r2 + 0, c2 + 1, dp);
//         int f3 = dfs(grid, l1, l2, r1 + 0, c1 + 1, r2 + 1, c2 + 0, dp);
//         int f4 = dfs(grid, l1, l2, r1 + 0, c1 + 1, r2 + 0, c2 + 1, dp);
//         cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
//         dp[r1][c1][r2][c2] = cherries;
//         return cherries;
//     }
//     public static void main(String[] args) {
//         int[][] grid = new int[][] {
//                 { 1, 1, -1 },
//                 { 1, 1, 1 },
//                 { -1, 1, 1 }
//         };
//         Solution solve = new Solution();
//         System.out.println("Max Cherries: " + solve.cherryPickup(grid));
//     }
// }
import java.util.*;

class Solution {

    public int cherryPickup(int[][] grid) {

        int l1 = grid.length;
        int l2 = grid[0].length;
        int[][][] dp = new int[l1][l2][l1];
        for (int[][] arr2D : dp) {
            for (int[] arr : arr2D) {
                Arrays.fill(arr, -1);
            }

        }
        int result = dfs(grid, l1, l2, 0, 0, 0, dp);
        return (result >= 0) ? result : 0;
    }

    public int dfs(int[][] grid, int l1, int l2, int r1, int c1, int r2, int[][][] dp) {
        int c2 = r1 + c1 - r2;

        if (r1 < 0 || r2 < 0 || c1 < 0 || c2 < 0
                || r1 >= l1 || r2 >= l1
                || c1 >= l2 || c2 >= l2
                || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }

        if (r1 == l1 - 1 && c1 == l2 - 1) {
            return grid[r1][c1];
        }

        int cherries = 0;

        if (r1 == r2 && c1 == c2) {
            cherries += (grid[r1][c1] | grid[r2][c2]);
        } else {
            cherries += (grid[r1][c1] + grid[r2][c2]);
        }

        int f1 = dfs(grid, l1, l2, r1 + 1, c1 + 0, r2 + 1, dp);
        int f2 = dfs(grid, l1, l2, r1 + 1, c1 + 0, r2 + 0, dp);
        int f3 = dfs(grid, l1, l2, r1 + 0, c1 + 1, r2 + 1, dp);
        int f4 = dfs(grid, l1, l2, r1 + 0, c1 + 1, r2 + 0, dp);

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));

        dp[r1][c1][r2] = cherries;

        return cherries;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1, 1, -1},
            {1, 1, 1},
            {-1, 1, 1}
        };

        Solution solve = new Solution();

        System.out.println("Max Cherries: " + solve.cherryPickup(grid));
    }
}
