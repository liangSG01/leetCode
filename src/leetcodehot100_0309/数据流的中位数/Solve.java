package leetcodehot100_0309.数据流的中位数;

import java.util.PriorityQueue;

public class Solve {

    public static void main(String[] args) {
        MedieFindler mf = new MedieFindler();
        mf.addNum(1);
        mf.addNum(5);
        mf.addNum(6);
        mf.addNum(2);
        mf.addNum(2);
        mf.addNum(9);
        mf.addNum(9);
        // 1 2 2  5 6 9 9
        double res = mf.findMedian();
        System.out.println(res);
    }
}
class MedieFindler{
    public static PriorityQueue<Integer> leftQueue;
    public static PriorityQueue<Integer> rightQueue;

    // 6 3 2 1
    // 7 8 9
    public MedieFindler(){
        leftQueue = new PriorityQueue<>((a, b) -> b - a);
        rightQueue = new PriorityQueue<>((a, b) -> a - b);
    }
    void addNum(int num){
        if(leftQueue.size() == rightQueue.size()){
            rightQueue.add(num);
            int numTemp = rightQueue.poll();
            leftQueue.add(numTemp);
        }
        else {
            leftQueue.add(num);
            int numTemp = leftQueue.poll();
            rightQueue.add(numTemp);
        }
    }
    double findMedian(){
        if(leftQueue.size() == rightQueue.size()){
            return (leftQueue.poll() + rightQueue.poll()) / 2.0;
        }
        else {
            return leftQueue.poll();
        }
    }
}
