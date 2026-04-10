package leetcodehot100_0309.最长有效括号;

public class Solve {
    public static int solution(String s){
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - 2 - dp[i - 1]] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int res = solution("()))()");
        System.out.println(res);
    }
}
