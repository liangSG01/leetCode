package leetcodehot100_0309.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solve {
    public static int[][] solution(int n) {
      int[][] res = new int[n][];
      for(int i = 0; i < n; i++){
          res[i] = new int[i + 1];
          res[i][0] = 1;
          res[i][i] = 1;
          for(int j = 1; j < i; j++){
              res[i][j] = res[i-1][j-1] + res[i-1][j];
          }
      }
      return res;
    }

    public static void main(String[] args) {
        int[][] yanghui = solution(6);
        // 打印验证结果
        for (int[] row : yanghui) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
