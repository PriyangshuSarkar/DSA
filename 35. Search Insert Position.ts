function searchInsert(nums: number[], target: number): number {
  let start = 0;
  let end = nums.length - 1;

  while (start <= end) {
    let middle = Math.ceil((start + end) / 2);

    if (nums[middle] < target) {
      start = middle + 1;
    } else if (target < nums[middle]) {
      end = middle - 1;
    } else return middle;
  }

  return start;
}

