package 懂车帝验证;

public class SudokuValidator {


    public static boolean solve(int[][] board){
        //验证每行是否重复
        for(int i = 0; i < 9; i++){
            boolean[] repeat = new boolean[9];
            for(int j = 0; j < 9; j++){
                int num = board[i][j];
                if (num < 1 || num > 9) return false;
                if(repeat[num - 1]) return false;
                repeat[num - 1] = true;
            }
        }
        //验证每列是否重复
        for(int j = 0; j < 9; j++) {
            boolean[] repeat = new boolean[9];
            for (int i = 0; i < 9; i++) {
                int num = board[i][j];
                if (num < 1 || num > 9) return false;
                if (repeat[num - 1]) return false;
                repeat[num - 1] = true;
            }
        }
        //验证每个小格
        for(int block = 0; block < 9; block++){
            boolean[] repeat = new boolean[9];
            int startRow = (block / 3) * 3;
            int startCol = (block % 3) * 3;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int num = board[startRow + i][startCol + j];
                    if (num < 1 || num > 9) return false;
                    if (repeat[num - 1]) return false;
                    repeat[num - 1] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };

        System.out.println("数独是否合法? " + solve(sudoku));
    }
}
