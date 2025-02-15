import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(entrance);

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        int level = 0;

        visited[entrance[0]][entrance[1]] = true;

        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            while (size > 0) {
                size--;

                int[] coordinates = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int[] dir = dirs[j];
                    int nextR = coordinates[0] + dir[0];
                    int nextC = coordinates[1] + dir[1];

                    if (nextR >= 0 && nextR < maze.length && nextC >= 0 && nextC < maze[0].length
                            && maze[nextR][nextC] == '.' && !visited[nextR][nextC]) {

                        if (nextR == 0 || nextR == maze.length - 1 || nextC == 0 || nextC == maze[0].length - 1) {
                            return level;
                        }

                        visited[nextR][nextC] = true;
                        queue.offer(new int[] { nextR, nextC });
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] maze = new char[][] {
                { '+', '+', '.', '+' },
                { '.', '.', '.', '+' },
                { '+', '+', '+', '.' }
        };
        int[] entrance = new int[] { 1, 2 };

        // Print the maze
        System.out.println("Maze:");
        for (char[] row : maze) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Entrance: " + Arrays.toString(entrance));
        System.out.println("Result: " + solution.nearestExit(maze, entrance));
    }
}