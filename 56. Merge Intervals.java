import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]); // Merge intervals
            } else {
                list.add(current);
            }
        }

        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] intervals = {
                { 1, 4 }, { 4, 5 }
        };

        int[][] mergedIntervals = solution.merge(intervals);

        visualizeIntervals(Arrays.asList(mergedIntervals));
    }

    public static void visualizeIntervals(List<int[]> intervals) {
        System.out.print("🌟 Intervals: ");
        for (int[] interval : intervals) {
            System.out.print(" [" + interval[0] + "⟶" + interval[1] + "] ");
        }
        System.out.println();
    }
}