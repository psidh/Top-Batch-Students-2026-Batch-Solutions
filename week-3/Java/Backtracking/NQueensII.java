
public class NQueensII {
    /*
     * The n-queens puzzle is the problem of placing n queens on an n x n
     * chessboard such that no two queens attack each other.
     * 
     * Given an integer n, return the number of distinct solutions to the n-queens
     * puzzle.
     * 
     * Each solution contains a distinct board configuration of the n-queens'
     * placement, where 'Q' and '.' both indicate a queen and an empty space,
     * respectively.
     */

    public static void main(String[] args) {
        System.out.println(solveNQueensII(4));
    }

    private static int solveNQueensII(int n) {
        int[] ans = { 0 };
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board, ans, 0, n);

        return ans[0];
    }

    private static void solve(char[][] board, int[] ans, int col, int n) {
        if (col == n) {
            ans[0]++;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (valid(row, col, n, board)) {
                board[row][col] = 'Q';
                solve(board, ans, col + 1, n);
                board[row][col] = '.';
            }
        }
        return;
    }

    private static boolean valid(int row, int col, int n, char[][] board) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q')
                return false;
        }

        for (int i = row, j = col; i < n && j >= 0; j--, i++) {
            if (board[i][j] == 'Q')
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; j--, i--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}
