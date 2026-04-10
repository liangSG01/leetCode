package MatrixText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MatrixText {
    private int[][] matrix;
    public MatrixText() {
        matrix = new int[10][10];
        initializeMatrix();
    }
    private void initializeMatrix() {
        // 生成1-100的数字列表
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        // 随机打乱顺序
        Collections.shuffle(numbers);

        // 填充二维数组
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = numbers.get(index++);
            }
        }
    }
    public void displayMatrix() {
        // 按行列显示数据
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    public void findMax() {
        // 查找最大值及其行号和列号
        int maxVal = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[i][j] > maxVal) {
                    maxVal = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("最大值: " + maxVal);
        System.out.println("行号: " + maxRow);
        System.out.println("列号: " + maxCol);
    }
    public static void main(String[] args) {
        MatrixText matrixText = new MatrixText();
        System.out.println("随机生成的矩阵:");
        matrixText.displayMatrix();
        System.out.println("\n矩阵中的最大值及其位置:");
        matrixText.findMax();
    }
}    