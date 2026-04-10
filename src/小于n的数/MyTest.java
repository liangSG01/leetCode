package 小于n的数;

public class MyTest {

    static int value = 24132;
    static String str = String.valueOf(value);
    static int[] arr = {1,4,9};

    static int result = -1;

    static boolean DFS(int index, boolean flag, int sum, int[] arr){

        if(index==str.length()){
            result = sum;
            return true;
        }
        if(flag){
            return DFS(index+1,true,sum*10+arr[arr.length-1],arr);
        }
        else {
            int tmp = str.charAt(index)-'0';
//            System.out.println(tmp);
            for(int i=arr.length-1;i>=0;i--){
                if(arr[i]==tmp){
                    if(DFS(index+1,false,sum*10+arr[i],arr)){
                        return true;
                    }
                } else if (arr[i]<tmp) {
                    if(DFS(index+1,true,sum*10+arr[i],arr)){
                        return true;
                    }
                }
            }
        }
        // 数组中最小的元素都大于数字该位的值
        if(index!=0) return false;  // 回溯一步（退回一步）
        else return DFS(index+1,true,sum,arr);
    }

    public static void main(String[] args) {
        DFS(0,false,0,arr);
    }
}
