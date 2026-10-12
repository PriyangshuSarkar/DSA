function findContentChildren(g: number[], s: number[]): number {
  g.sort((a, b) => a - b);
  s.sort((a, b) => a - b);

  let first = 0;
  let second = 0;

  while (first < g.length && second < s.length) {
    if (g[first] <= s[second]) {
      first++;
    }
    second++;
  }
  return first;
}

console.debug(findContentChildren([10, 9, 8, 7], [5, 6, 7, 8]));
