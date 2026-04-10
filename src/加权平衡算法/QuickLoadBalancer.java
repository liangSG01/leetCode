//package 加权平衡算法;
//
//import java.util.Arrays;
//import java.util.Random;
//
//public class QuickLoadBalancer {
//
//    private double[] weights;
//    private double[] currentWeights;
//    private double totalWeight = 0;
//
//    public QuickLoadBalancer(double[] weights) {
//        Arrays.cop
//        this.weights = weights;
//        this.currentWeights = new double[weights.length];
//        for (double w : weights) {
//            this.totalWeight += w;
//        }
//    }
//
//    public int select() {
//        int bestIndex = -1;
//        double maxWeight = Double.NEGATIVE_INFINITY;
//
//        // 找出当前权重最大的服务器
//        for (int i = 0; i < weights.length; i++) {
//            currentWeights[i] += weights[i];
//            if (currentWeights[i] > maxWeight) {
//                maxWeight = currentWeights[i];
//                bestIndex = i;
//            }
//        }
//
//        // 更新被选中服务器的当前权重
//        currentWeights[bestIndex] -= totalWeight;
//        return bestIndex;
//    }
//
//    public static void main(String[] args) {
//        // 输入
//        double[] serverWeights = {1.0, 1.05, 1.001, 10.0, 2.5, 1.0, 1.0, 1.0};
//        QuickLoadBalancer lb = new QuickLoadBalancer(serverWeights);
//
//        // 输出: 模拟15次请求，打印每次选择的服务器索引
//        int[] result = new int[15];
//        for (int i = 0; i < 15; i++) {
//            result[i] = lb.select();
//        }
//
//        System.out.println("选择的服务器索引序列: " + Arrays.toString(result));
//    }
//}