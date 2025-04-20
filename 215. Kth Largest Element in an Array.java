import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);

    }

    public int quickSelect(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[start];
        }

        int pivotIndex = partition(nums, start, end);

        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, end, k);
        } else {
            return quickSelect(nums, start, pivotIndex - 1, k);
        }

    }

    public int partition(int[] nums, int start, int end) {

        int pivotIndex = new Random().nextInt(end - start + 1) + start;

        int pivot = nums[pivotIndex];

        swap(nums, pivotIndex, end);

        int sortIndex = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                swap(nums, sortIndex, i);
                sortIndex++;
            }
        }

        swap(nums, sortIndex, end);
        return sortIndex;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}