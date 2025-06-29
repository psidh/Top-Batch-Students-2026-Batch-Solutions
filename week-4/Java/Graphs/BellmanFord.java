import java.util.*;

class Pair {
    int node, weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class BellmanFord{
    static final int INF = Integer.MAX_VALUE;

    public static void bellmanFord(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Flatten adj list into edge list
        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (Pair p : adj.get(u)) {
                edges.add(new int[]{u, p.node, p.weight});
            }
        }

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], wt = edge[2];
                if (dist[u] != INF && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative cycles
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (dist[u] != INF && dist[u] + wt < dist[v]) {
                System.out.println("Negative weight cycle detected");
                return;
            }
        }

        // Output distances
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from src to " + i + ": " +
                    (dist[i] == INF ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add edges: u -> v with weight
        adj.get(0).add(new Pair(1, -1));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 3));
        adj.get(1).add(new Pair(3, 2));
        adj.get(1).add(new Pair(4, 2));
        adj.get(3).add(new Pair(2, 5));
        adj.get(3).add(new Pair(1, 1));
        adj.get(4).add(new Pair(3, -3));

        bellmanFord(V, adj, 0);
    }
}
