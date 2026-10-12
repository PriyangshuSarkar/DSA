// function singleNumber(nums: number[]): number {
//   const set = new Set<number>();
//
//   for (const num of nums) {
//     if (set.has(num)) {
//       set.delete(num);
//     } else {
//       set.add(num);
//     }
//   }
//
//   return set.values().next().value!;
// }

function singleNumber(nums: number[]): number {
  let result: number = 0;

  for (let num of nums) {
    result ^= num;
  }

  return result;
}

console.debug(singleNumber([2, 2, 1]));

