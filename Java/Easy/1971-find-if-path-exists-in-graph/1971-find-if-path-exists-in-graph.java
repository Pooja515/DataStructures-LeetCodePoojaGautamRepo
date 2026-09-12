class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dfs(source, destination, adj, visited);
    }

    boolean dfs(int source, int destination, List<List<Integer>> adj, boolean[] visited) {
        if (source == destination)
            return true;
        visited[source] = true;
        for (int neigh : adj.get(source)) {
            if (!visited[neigh]) {
                if (dfs(neigh, destination, adj, visited))
                    return true;
            }
        }
        return false;
    }
}