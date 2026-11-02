function lengthOfLongestSubstring(s: string): number {
  const set = new Set<string>();

  const length = s.length;
  let first = 0;
  let slow = first;
  let result = 0;

  while (first < length) {
    const has = set.has(s.charAt(first));

    if (!has) {
      set.add(s.charAt(first));
      first++;
    } else {
      set.delete(s.charAt(slow));
      slow++;
    }

    result = Math.max(result, first - slow);
  }
  return result;
}

