function groupAnagrams(strs: string[]): string[][] {
  const map = new Map<string, string[]>();

  for (let str of strs) {
    const sorted = str.split("").sort().join("");

    const hasValue = map.get(sorted);
    if (hasValue) {
      hasValue.push(str);
    } else {
      map.set(sorted, [str]);
    }
  }

  return Array.from(map.values());
}

