package leetcodehot100_0309.下一个温度更高的日子;

import java.util.Arrays;
import java.util.LinkedList;

public class Solve {

    public static int[] func(int[] nums){
        // stack 存索引
        int[] res = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        int[] res = func(nums);
        System.out.println(Arrays.toString(res));
    }
}
