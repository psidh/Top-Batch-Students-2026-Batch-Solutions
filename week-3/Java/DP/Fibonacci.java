import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        System.out.println(fib(4, dp));
    }

    private static int fib(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0)
            return dp[n];

        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }
}
