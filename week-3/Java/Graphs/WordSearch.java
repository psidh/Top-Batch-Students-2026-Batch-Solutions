
public class WordSearch {
    public static void main(String[] args) {

        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

        System.out.println(exist(board, "ABCED"));
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (board[i][j] == word.charAt(0) && dfs(i, j, board, word, vis, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, char[][] board, String word, boolean[][] vis,
            int index) {
        int n = board.length;
        int m = board[0].length;

        if (index == word.length()) {
            return true;
        }

        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int nr = delrow[k] + i;
            int nc = delcol[k] + j;

            if (nr >= 0 &&
                    nr < n &&
                    nc >= 0 &&
                    nc < m &&
                    !vis[nr][nc] && board[nr][nc] == word.charAt(index)) {
                if (dfs(nr, nc, board, word, vis, index + 1))
                    return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
}
