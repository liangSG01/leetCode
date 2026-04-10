package leetcodehot100_0309.前K个高频元素;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solve {

    public static int[] func(int[] nums, int k){
        int[] res = new int[k];
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()){
            if(queue.size() < k){
                queue.add(num);
            }
            else{
                queue.add(num);
                queue.poll();
            }
            }
        for(int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
