import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class D_Minimum_Threshold_Path_With_K_Heavy_Edges {
    private boolean isPossible(int thres, ArrayList<int[]>[] graph, int k, int src, int dest) {
        int n = graph.length;
        boolean[][] visited = new boolean[n][k + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[src][0] = true;
        queue.add(new int[]{src, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int v = curr[0];
            if (v == dest) {
                return true;
            }
            for (int[] neigh : graph[v]) {
                int w = neigh[1];
                int e = curr[1];
                if (w > thres) {
                    e += 1;
                }

                if (e <= k && !visited[neigh[0]][e]) {
                    queue.add(new int[]{neigh[0], e});
                    visited[neigh[0]][e] = true;
                }
            }
        }

        return false;
    }

    private void constructGraph(ArrayList<int[]>[] graph, int[][] edges) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
    }


    public int minimumThreshold(int n, int[][] edges, int src, int target, int k) {
        if (src == target) {
            return 0;
        }

        ArrayList<int[]> graph[] = new ArrayList[n];
        constructGraph(graph, edges);

        int low = 0, high = 0;
        for (int[] edge : edges) {
            int w = edge[2];
            high = Math.max(w, high);
        }
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, graph, k, src, target)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
