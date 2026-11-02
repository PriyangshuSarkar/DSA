function rob(nums: number[]): number {
  const length = nums.length;

  const map = new Map<number, number>();

  function recursion(index: number): number {
    if (index >= length) return 0;
    const value = map.get(index);
    if (value !== undefined) return value;

    const result = Math.max(
      recursion(index + 1),
      recursion(index + 2) + nums[index],
    );
    map.set(index, result);
    return result;
  }

  return recursion(0);
}

console.log(rob([1, 2]));
