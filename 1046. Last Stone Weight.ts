function lastStoneWeight(stones: number[]): number {
  if (stones.length === 0) return 0;
  stones.sort((a, b) => a - b);

  const y = stones.pop();
  const x = stones.pop();

  if (y && !x) {
    return y;
  } else if (!!y && !!x && y > x) {
    stones.push(y - x);
  } else if (!y || !x || x > y) {
    throw new Error("Wrong Logic!");
  }

  return lastStoneWeight(stones);
}

console.log("result", lastStoneWeight([2, 7, 4, 1, 8, 1]));
