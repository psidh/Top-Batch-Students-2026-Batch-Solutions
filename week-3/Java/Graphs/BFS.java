import java.util.*;

public class BFS {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        int n = 3;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        BreadthFirstSearch(adj, n);
    }

    static void BreadthFirstSearch(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}
