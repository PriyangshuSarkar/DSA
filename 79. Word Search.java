
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, int row, int col, String word, int index, boolean[][] visited) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || board.length <= row || col < 0 || board[0].length <= col || visited[row][col] == true
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        boolean found = dfs(board, row + 1, col, word, index + 1, visited)
                || dfs(board, row - 1, col, word, index + 1, visited)
                || dfs(board, row, col + 1, word, index + 1, visited)
                || dfs(board, row, col - 1, word, index + 1, visited);

        visited[row][col] = false;

        return found;

    }
}