import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class EscapeMaze {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }

        return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] target, Set<String> blockedSet) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(start);
        visited.add(start[0] + "," + start[1]);

        int[] delrow = { -1, 0, 1, 0 };
        int[] delcol = { 0, 1, 0, -1 };

        int MAX_MOVES = 19901;

        while (!q.isEmpty() && visited.size() < MAX_MOVES) {
            int[] grid = q.poll();
            int x = grid[0], y = grid[1];

            if (x == target[0] && y == target[1])
                return true;

            for (int k = 0; k < 4; k++) {
                int nrow = x + delrow[k], ncol = y + delcol[k];
                if (nrow >= 0 && nrow < 1_000_000 && ncol >= 0 && ncol < 1_000_000 &&
                        !visited.contains(nrow + "," + ncol) &&
                        !blockedSet.contains(nrow + "," + ncol)) {

                    visited.add(nrow + "," + ncol);
                    q.add(new int[] { nrow, ncol });
                }
            }
        }

        return visited.size() >= MAX_MOVES;
    }
}
