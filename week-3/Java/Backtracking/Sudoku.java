import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {
        char[][] game = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        solve(game);
        for (char[] x : game) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static void solveSudoku(char[][] grid) {
        solve(grid);
    }

    private static boolean solve(char[][] grid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (valid(i, j, digit, grid)) {
                            grid[i][j] = digit;
                            if (solve(grid))
                                return true;
                            grid[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid(int i, int j, char digit, char[][] grid) {
        for (int iter = 0; iter < 9; iter++) {
            if (grid[iter][j] == digit || grid[i][iter] == digit)
                return false;
        }

        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;

        for (int row = rowStart; row < rowStart + 3; row++) {
            for (int col = colStart; col < colStart + 3; col++) {
                if (grid[row][col] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

}
