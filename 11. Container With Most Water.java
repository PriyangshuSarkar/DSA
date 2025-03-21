class Solution {
    public int maxArea(int[] height) {

        if (height == null)
            return 0;

        int first = 0, second = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (first <= second) {
            int l = Math.min(height[first], height[second]);
            int h = second - first;
            int area = l * h;
            maxArea = Math.max(maxArea, area);
            if (height[first] < height[second]) {
                first++;
            } else {
                second--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] height = { 8, 7, 2, 1 };

        System.out.println(solution.maxArea(height));
    }
}