class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        List<Integer> result = new ArrayList<>();

        // 0 = unvisited, 1 = visiting, 2 = safe, 3 = unsafe

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                result.add(i);
            }
        }

        // Nodes are checked in increasing order, so result is sorted.
        return result;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] == 1) {
            return false; // Cycle detected
        }

        if (state[node] == 2) {
            return true; // Already known to be safe
        }

        if (state[node] == 3) {
            return false; // Already known to be unsafe
        }

        state[node] = 1; // Mark as visiting

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, state)) {
                state[node] = 3; // One unsafe path makes node unsafe
                return false;
            }
        }

        state[node] = 2; // All paths lead to safe nodes
        return true;
    }
}
