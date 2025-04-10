// LC 84



class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int startIndex = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, h * (i - startIndex - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int startIndex = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, h * (n - startIndex - 1));
        }

        return maxArea;
    }
}
/*
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/