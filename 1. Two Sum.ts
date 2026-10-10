// function twoSum(nums: number[], target: number): number[] {
//   const length = nums.length;
//
//   if (length <= 1) {
//     return [0, 0];
//   }
//
//   let first = 0;
//
//   while (first < length - 1) {
//     let second = first + 1;
//
//     while (second < length) {
//       const sum = nums[first] + nums[second];
//       if (sum === target) {
//         return [first, second];
//       }
//       second++;
//     }
//
//     first++;
//   }
//
//   return [0, 0];
// }

function twoSum(nums: number[], target: number): number[] {
  const length = nums.length;

  if (length <= 1) {
    return [0, 0];
  }

  const map = new Map<number, number>();

  for (let i = 0; i < length; i++) {
    const val = nums[i];
    const key = map.get(val);
    if (key !== undefined) {
      return [key, i];
    }
    const diff = target - val;
    map.set(diff, i);
  }

  return [0, 0];
}
