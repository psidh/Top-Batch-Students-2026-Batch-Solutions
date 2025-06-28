class UnionFind {
    public int[] rank;
    public int[] parent;

    UnionFind(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int findParent(int u) {
        if (parent[u] != u)
            parent[u] = findParent(parent[u]);
        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU == rootV)
            return;

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    public boolean isConnected(int u, int v) {
        return findParent(u) == findParent(v);
    }
}

public class DetectCycle {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 1, 4 } // This creates a cycle
        };

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                System.out.println("Cycle Detected");
                return;
            }
            uf.union(edge[0], edge[1]);

        }

        System.out.println("No cycle detected");
    }
}