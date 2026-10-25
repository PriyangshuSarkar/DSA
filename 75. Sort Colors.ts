// /**
//  Do not return anything, modify nums in-place instead.
//  */
// function sortColors(nums: number[]): void {
//   quickSort(nums, 0, nums.length - 1);
// }
//
// function quickSort(arr: number[], low: number, high: number): void {
//   if (low >= high) return;
//
//   const pivotIndex = partition(arr, low, high);
//
//   quickSort(arr, low, pivotIndex - 1);
//   quickSort(arr, pivotIndex + 1, high);
// }
//
// function partition(arr: number[], low: number, high: number): number {
//   const pivot = arr[high];
//   let i = low - 1;
//
//   for (let j = low; j < high; j++) {
//     if (arr[j] <= pivot) {
//       i++;
//       [arr[i], arr[j]] = [arr[j], arr[i]];
//     }
//   }
//
//   [arr[i + 1], arr[high]] = [arr[high], arr[i + 1]];
//
//   return i + 1;
// }

/**
 Do not return anything, modify nums in-place instead.
 */
function sortColors(nums: number[]): void {
  let low = 0;
  let mid = low;
  let high = nums.length - 1;

  while (mid <= high) {
    if (nums[mid] === 0) {
      [nums[low], nums[mid]] = [nums[mid], nums[low]];
      low++;
      mid++;
    } else if (nums[mid] === 1) {
      mid++;
    } else if (nums[mid] === 2) {
      [nums[high], nums[mid]] = [nums[mid], nums[high]];
      high--;
    }
  }
}
