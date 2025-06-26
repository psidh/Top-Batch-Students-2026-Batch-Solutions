import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
     * LIS stands for Longest Increasing Subsequence.
     * 
     * It refers to the longest subsequence (not necessarily contiguous) of a
     * sequence such that all elements of the subsequence are strictly increasing.
     */
    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        /*
         * The LIS is: [2, 3, 7, 101]
         */
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 1;
        for (int val : dp)
            max = Math.max(max, val);
        return max;
    }

    private static int memoization(int currIndex, int prevIndex, int[] arr, int[][] dp) {
        if (currIndex >= arr.length) {
            return 0;
        }

        if (dp[currIndex][prevIndex + 1] != -1)
            return dp[currIndex][prevIndex + 1];
        int take = 0;

        if (prevIndex == -1 || arr[currIndex] > arr[prevIndex]) {
            take = 1 + memoization(currIndex + 1, currIndex, arr, dp);
        }

        int notTake = memoization(currIndex + 1, currIndex, arr, dp);

        return dp[currIndex][prevIndex + 1] = Math.max(notTake, take);

    }
    
}
