package 筛子概率;

import java.util.Arrays;

class Solve {

    public static double[] dicesProbability(int n) {

        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        for (int i = 2; i <= n; i++) {

            double[] temp = new double[5 * i + 1];

            for (int j = 0; j < dp.length; j++) {

                for (int k = 1; k <= 6; k++) {

                    temp[j + k - 1] = temp[j + k - 1] + dp[j] * (1.0 / 6.0);
                }
            }

            dp = temp;
        }

        return dp;
    }

    public static void main(String[] args) {
        double[] res1 = dicesProbability(1);
        System.out.println("n=1 (总和 1-6): " + Arrays.toString(res1));

        double[] res2 = dicesProbability(3);
        System.out.println("n=2 (总和 2-12): " + Arrays.toString(res2));
    }
}