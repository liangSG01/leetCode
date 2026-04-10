package leetcodehot100_0309.找出第K大的数;

public class Solve {


    public static int func(int[] nums, int k) {
        // 123456
        k = nums.length - k;
        return helper(nums, k, 0, nums.length - 1);
    }
    public static int helper(int[] nums, int k, int left, int right){
        int pivot = partition(nums, 0, nums.length - 1);
        if(k == pivot) return nums[k];
        else if(k < pivot) return partition(nums, left, pivot - 1);
        else return helper(nums, k, pivot + 1, right);
    }

    static int partition(int[] nums, int left, int right){
        int x = nums[left];
        while(left < right){
            while(left < right && nums[right] >= x){
                right--;
            }
            if(left < right){
                nums[left] = nums[right];
            }
            while(left < right && nums[left] <= x){
                left++;
            }
            if(left < right){
                nums[right] = nums[left];
            }
            nums[left] = x;
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
