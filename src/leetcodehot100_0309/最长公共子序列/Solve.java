package leetcodehot100_0309.最长公共子序列;

public class Solve {
    public static int func(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                     System.out.println("debug");

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    System.out.println("debug");
                }
            }
        }

        // 右下角的最后一个元素，就是整个 s1 和 s2 的最大公共子序列长度
        return dp[n1][n2];
    }
    public static void main(String[] args) {
        int res = func("abcde", "ace");
    }
}
