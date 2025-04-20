// import java.util.Random;

class Solution {
    public void sortColors(int[] nums) {

        // quickSort(nums, 0, nums.length - 1);

        bucketSort(nums);

    }

    public void bucketSort(int[] nums) {
        int[] bucket = new int[3];

        for (int n : nums) {
            bucket[n]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (bucket[0] != 0) {
                nums[i] = 0;
                bucket[0]--;
            } else if (bucket[1] != 0) {
                nums[i] = 1;
                bucket[1]--;
            } else if (bucket[2] != 0) {
                nums[i] = 2;
                bucket[2]--;
            }
        }
    }

    // public void quickSort(int[] nums, int start, int end) {
    // if (start < end) {
    // int pivotIndex = partition(nums, start, end);

    // quickSort(nums, pivotIndex + 1, end);
    // quickSort(nums, start, pivotIndex - 1);
    // }
    // }

    // public int partition(int[] nums, int start, int end) {
    // int pivotIndex = new Random().nextInt(end - start) + start;

    // int pivot = nums[pivotIndex];

    // swap(nums, pivotIndex, end);

    // int swapIndex = start;

    // for (int i = start; i < end; i++) {
    // if (nums[i] < pivot) {
    // swap(nums, swapIndex, i);
    // swapIndex++;
    // }
    // }

    // swap(nums, swapIndex, end);

    // return swapIndex;
    // }

    // public void swap(int[] nums, int i, int j) {
    // int temp = nums[i];
    // nums[i] = nums[j];
    // nums[j] = temp;
    // }
}