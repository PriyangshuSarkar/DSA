function search(nums: number[], target: number): number {
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    const middle = Math.ceil((start + end) / 2);

    if (nums[middle] < target) {
      start = middle + 1;
    } else if (target < nums[middle]) {
      end = middle - 1;
    } else return middle;
  }

  return -1;
}

console.log(search([5], 5));
