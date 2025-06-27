import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
     * The n-queens puzzle is the problem of placing n queens on an n x n
     * chessboard such that no two queens attack each other.
     * 
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You
     * may return the answer in any order.
     * 
     * Each solution contains a distinct board configuration of the n-queens'
     * placement, where 'Q' and '.' both indicate a queen and an empty space,
     * respectively.
     */

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, n, board, ans);

        return ans;
    }

    private static void solve(int col, int n, char[][] board, List<List<String>> ans) {
        if (col == n) {
            ans.add(helper(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (valid(row, col, n, board)) {
                board[row][col] = 'Q';
                solve(col + 1, n, board, ans);
                board[row][col] = '.';
            }
        }

        return;
    }

    private static boolean valid(int row, int col, int n, char[][] board) {

        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q')
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        for (int i = row, j = col; i < n && j >= 0; j--, i++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    private static List<String> helper(char[][] board) {

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }
        return temp;
    }

}
