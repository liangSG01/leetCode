package leetcodehot100_0309.单词拆分;

public class Solve {
    public static boolean solution(String s, String[] wordDict){

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String word : wordDict){
                int len = word.length();
                if(i >= len && dp[i - len] && s.substring(i - len, i).equals(word)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        boolean res = solution("leetcode", new String[]{"leet", "code"});
        System.out.println(res); // 输出: true
    }
}