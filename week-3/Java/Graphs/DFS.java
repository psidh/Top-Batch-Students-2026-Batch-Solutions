import java.util.*;

public class DFS {
    public static void main(String[] args) {

        List<List<Integer>> adj = new ArrayList<>();
        int n = 4;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(3).add(2);
        DepthFirstSearch(adj, n);
    }

    static void DepthFirstSearch(List<List<Integer>> adj, int n) {
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis);
            }
        }
        return;
    }

    static void dfs(List<List<Integer>> adj, int node, boolean[] vis) {
        vis[node] = true;
        System.out.println(node);
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(adj, neighbor, vis);
            }
        }
    }
}