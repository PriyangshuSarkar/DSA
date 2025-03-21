import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return nums[low]; // Base case: Only one element left
        }

        int pivotIndex = partition(nums, low, high);

        if (pivotIndex == k) {
            return nums[pivotIndex]; // Found kth largest
        } else if (pivotIndex > k) {
            return quickSelect(nums, low, pivotIndex - 1, k); // Search left partition
        } else {
            return quickSelect(nums, pivotIndex + 1, high, k); // Search right partition
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivotIndex = new Random().nextInt(high - low + 1) + low;
        int pivot = nums[pivotIndex];

        swap(nums, pivotIndex, high); // Move pivot to the end
        int storeIndex = low; // Corrected initialization

        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                if (nums[storeIndex] > nums[i]) {
                    swap(nums, storeIndex, i);
                }
                storeIndex++;
            } else if (nums[i] == pivot) {
                swap(nums, storeIndex, i);
            }
        }

        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}