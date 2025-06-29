public class FloydWarshall {

    public static void main(String[] args) {
        int INF = 1000000000;

        int[][] graph = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        int n = graph.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] < INF && dp[k][j] < INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        System.out.println("Shortest distances between all pairs:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
