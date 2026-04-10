package 前K个最大元素;
import java.util.*;

public class Solve {
    public static List<Integer> solve(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int num : map.keySet()){
            if(heap.size() < k){
                heap.add(num);
            }
            else {
                heap.add(num);
                heap.poll();
            }
        }
        //循环结束后就是一个最小堆
        while(!heap.isEmpty()){
            res.add(heap.poll());
        }
        //按从高频到低频排序
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,2,2,2,2,1,1,1,1};
        int k = 2;
        List<Integer> res = solve(nums, k);
        System.out.println(res);
    }
}
