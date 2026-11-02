function numIslands(grid: string[][]): number {
  let count = 0;

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      if (grid[i][j] === "1") {
        helper(i, j);
        count++;
      }
    }
  }

  function helper(row: number, col: number): void {
    if (
      row < 0 ||
      row >= grid.length ||
      col < 0 ||
      col >= grid[row].length ||
      grid[row][col] === "0"
    )
      return;

    grid[row][col] = "0";

    helper(row + 1, col);
    helper(row, col + 1);
    helper(row - 1, col);
    helper(row, col - 1);
  }

  return count;
}

console.log(
  numIslands([
    ["1", "1", "1", "1", "0"],
    ["1", "1", "0", "1", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "0", "0", "0"],
  ]),
);
