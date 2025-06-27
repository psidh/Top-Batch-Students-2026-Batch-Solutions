import java.util.*;

public class CycleDetectionUndirected {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected)
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2); // creates a cycle
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);

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

    public static boolean detect(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (dfs(adj, i, -1, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, int node, int parent, boolean[] vis) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(adj, neighbor, node, vis)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // cycle found
            }
        }

        return false;
    }
}
