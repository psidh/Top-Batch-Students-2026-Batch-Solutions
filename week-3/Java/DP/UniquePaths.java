import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.print(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return function(0, 0, m, n, dp);
    }

    private static int function(int i, int j, int m, int n, int dp[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return 0;

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = function(i, j + 1, m, n, dp);
        int right = function(i + 1, j, m, n, dp);

        return dp[i][j] = down + right;
    }
}
