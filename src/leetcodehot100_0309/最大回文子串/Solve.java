package leetcodehot100_0309.最大回文子串;

public class Solve {

    public static String func(String s){

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int k = 0; k < n; k++){
            dp[k][k] = true;
        }
        // bababd
        // 先特殊处理长度为2的
        int maxIndex = 0;
        int maxLength = 0;
        for(int left = 0; left < n - 2; left++){
            int right = left + 1;
            if((s.charAt(left) == s.charAt(right))){
                dp[left][right] = true;
                if(maxLength < right - left + 1){
                    maxLength = right - left + 1;
                    maxIndex = left;
                }
            }
        }
        for(int length = 3; length <= n; length++){
            for(int left = 0; left <= n - length; left++){
                int right = left + length - 1;
                if(dp[left+1][right-1] && (s.charAt(left) == s.charAt(right))){
                    dp[left][right] = true;
                    if(maxLength < right - left + 1){
                        maxLength = right - left + 1;
                        maxIndex = left;
                    }
                }
            }
        }
        return s.substring(maxIndex, maxIndex + maxLength);
    }
    public static void main(String[] args) {
        String s = func("babab");
        System.out.println(s);
    }
}
