import java.util.*;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        // Quick Select

        int n = nums.length;

        return quickSelect(nums, 0, n - 1, n - k);
        // //Heap
        // int l = nums.length;
        // if (l <= 0)
        // return 0;
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int ans = 0;
        // for (int n : nums) {
        // pq.add(n);
        // }
        // for (int i = 0; i < (l - k) + 1; i++) {
        // ans = pq.poll();
        // }
        // return ans;
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (pivotIndex == k) {
            return nums[pivotIndex];
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int nums[], int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];

        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 3, 2, 1, 5, 6, 4 };
        int k1 = 2;
        System.out.println(
            "The " +
            k1 +
            "th largest element is: " +
            solution.findKthLargest(nums1, k1)
        );
        // Expected Output: 5

        // Test case 2
        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;
        System.out.println(
            "The " +
            k2 +
            "th largest element is: " +
            solution.findKthLargest(nums2, k2)
        );
        // Expected Output: 4

        // Test case 3
        int[] nums3 = { 1 };
        int k3 = 1;
        System.out.println(
            "The " +
            k3 +
            "th largest element is: " +
            solution.findKthLargest(nums3, k3)
        );
        // Expected Output: 1

        // Test case 4
        int[] nums4 = { 7, 10, 4, 3, 20, 15 };
        int k4 = 3;
        System.out.println(
            "The " +
            k4 +
            "th largest element is: " +
            solution.findKthLargest(nums4, k4)
        );
        // Expected Output: 10
    }
}
