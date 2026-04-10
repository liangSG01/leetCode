package leetcodehot100_0309.买卖股票的最佳时机;

public class Solve {
    public static int func(int[] nums){
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < minPrice){
                minPrice = nums[i];
            }
            else if(nums[i] - minPrice > res){
                res = nums[i] - minPrice;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,6,5,4,3};
        int res = func(nums);
        System.out.println(res);
    }
}
