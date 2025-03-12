package StackDataStructure;
import java.util.Stack;
public class MaxRectangleAreaInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < heights.length) {
            if (s.isEmpty() || heights[i] >= heights[s.peek()]) {
                s.push(i++);
            }else{
                int top = s.pop();
                int area = heights[top] * (s.isEmpty() ? i : i - s.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!s.isEmpty()) {
            int top = s.pop();
            int area = heights[top] * (s.isEmpty() ? i : i - s.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Maximum Rectangular Area: " + largestRectangleArea(heights));
    }
}
