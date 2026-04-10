package leetcodehot100_0309.最大矩形;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Solve {

    public static int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] newHeights = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++){
            newHeights[i + 1] = heights[i];
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < newHeights.length; i++){
            while(!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]){
                int indexTemp = stack.pop();
                max = Math.max(newHeights[indexTemp] * (i - indexTemp), max);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int max = largestRectangleArea(heights);
        System.out.println(max);
    }
}
