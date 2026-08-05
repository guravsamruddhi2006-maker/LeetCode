import java.util.*;

class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Build graph
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        // Find all suspicious methods
        visited = new boolean[n];
        dfs(k);

        // Check if any outside method calls a suspicious method
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!visited[u] && visited[v]) {
                // Cannot remove anything
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Return remaining methods
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}