import java.util.Arrays;

public class MinimumCostPath {
    /*
     * Given a m x n grid filled with non-negative numbers, find a path from top
     * left to bottom right, which minimizes the sum of all numbers along its path.
     * 
     * Note: You can only move either down or right at any point in time.
     */
    public static void main(String[] args) {

        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.print(minimumCostPath(grid));
    }

    public static int minimumCostPath(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return function(0, 0, grid, dp);
    }

    private static int function(int i, int j, int[][] grid, int dp[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return (int) 1e9;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = grid[i][j] + function(i, j + 1, grid, dp);
        int right = grid[i][j] + function(i + 1, j, grid, dp);

        return dp[i][j] = Math.min(down, right);
    }
}
