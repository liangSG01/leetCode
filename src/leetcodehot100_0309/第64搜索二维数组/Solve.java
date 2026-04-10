package leetcodehot100_0309.第64搜索二维数组;

public class Solve {
    public static boolean func(int[][] nums, int target){
        int right = nums[0].length - 1;
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i][right] == target){
                return true;
            }
            if (nums[i][right] > target){
                return binaryFind(nums[i], target) == -1 ? false : true;
            }
        }
        return false;
    }

    public static int binaryFind(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // 没找到
    }
    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(func(nums,11));
    }
}
