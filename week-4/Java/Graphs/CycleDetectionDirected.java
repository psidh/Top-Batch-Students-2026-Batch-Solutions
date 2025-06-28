import java.util.ArrayList;
import java.util.List;

class CycleDetectionDirected {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        // Print adjacency list
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }

        // Detect cycle
        boolean hasCycle = detect(adj);
        System.out.println("Cycle present: " + hasCycle);
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // Undirected graph: add both ways
    }

    private static boolean detect(List<List<Integer>> adj) {

        int n = adj.size();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (dfs(i, adj, n, vis, -1))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adj, int n, boolean[] vis, int parent) {

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                vis[neighbor] = true;
                if (dfs(neighbor, adj, n, vis, node)) {
                    return true;
                }
            } else if (parent != neighbor) {
                return true;
            }
        }
        return false;
    }

}
