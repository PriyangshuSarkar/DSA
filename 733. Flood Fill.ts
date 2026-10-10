function floodFill(
  image: number[][],
  sr: number,
  sc: number,
  color: number,
): number[][] {
  const originalColor = image[sr][sc];

  if (originalColor !== color) {
    helper(image, sr, sc, originalColor, color);
  }

  return image;
}

function helper(
  image: number[][],
  sr: number,
  sc: number,
  originalColor: number,
  newColor: number,
) {
  if (isOutOfBounds(image, sr, sc) || image[sr][sc] !== originalColor) {
    return;
  }

  image[sr][sc] = newColor;

  const directions = [
    [-1, 0],
    [1, 0],
    [0, -1],
    [0, 1],
  ];
  for (const [dRow, dCol] of directions) {
    helper(image, sr + dRow, sc + dCol, originalColor, newColor);
  }
}

function isOutOfBounds<T>(grid: T[][], row: number, col: number): boolean {
  return row < 0 || row >= grid.length || col < 0 || col >= grid[row].length;
}

console.log(
  floodFill(
    [
      [1, 1, 1],
      [1, 1, 0],
      [1, 0, 1],
    ],
    1,
    1,
    2,
  ),
);
