import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        @SuppressWarnings({ "unsaved", "unchecked" })
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int bucketSize = bucket.length;
        int i = bucketSize - 1;
        int j = k - 1;
        int[] result = new int[k];
        while (i >= 0 && j >= 0) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    result[j] = n;
                    j--;
                }
            }
            i--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(10) + 1; // Generates numbers between 1 and 1000
        }

        int k = 2;

        Solution solution = new Solution();

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }

}