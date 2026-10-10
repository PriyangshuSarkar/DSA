function climbStairs(n: number): number {
  const map = new Map<number, number>();
  return helper(n, map);
}

function helper(n: number, map: Map<number, number>): number {
  if (n <= 2) return n;

  let count = 0;

  const val = map.get(n);

  if (val) {
    return val;
  } else {
    count += helper(n - 1, map);
    count += helper(n - 2, map);
    map.set(n, count);
  }

  return count;
}
