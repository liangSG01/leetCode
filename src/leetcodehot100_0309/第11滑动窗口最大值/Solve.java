package leetcodehot100_0309.第11滑动窗口最大值;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solve {
    public static List<Integer> func(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) return res;

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int right = 0; right < nums.length; right++){
            queue.add(nums[right]);
            // 第二步：出 (Remove) —— 如果遍历过的元素个数超过了 k，移除最左侧过期的老元素
            // 当 right >= k 时，说明当前窗口包含了 k + 1 个元素，必须踢掉 1 个
            if (right >= k) {
                queue.remove(nums[right - k]);
            }

            // 第三步：算 (Process) —— 当窗口大小达到 k 时，开始记录结果
            if (right >= k - 1) {
                res.add(queue.peek());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> res = func(nums, 3);
        System.out.println(res);
    }
}