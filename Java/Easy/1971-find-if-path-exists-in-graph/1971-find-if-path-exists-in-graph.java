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

    boolean dfs(int node, int destination, List<List<Integer>> adj, boolean[] visited) {

        if (node == destination)
            return true;
        visited[node] = true;
        for (int neig : adj.get(node)) {
            if (!visited[neig]) {
                if (dfs(neig, destination, adj, visited))
                    return true;
            }

        }
        return false;
    }
}