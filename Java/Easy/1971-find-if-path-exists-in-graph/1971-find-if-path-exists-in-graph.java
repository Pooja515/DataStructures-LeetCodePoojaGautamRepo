class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return dfs(source, visited, adj, destination);
    }

    boolean dfs(int source, boolean[] visited,List<List<Integer>> adj, int destination) {
       
        if (source == destination)
             return true;

        visited[source] = true;
        for (int neighbor : adj.get(source)) {
            if (!visited[neighbor]) {
                if(dfs(neighbor, visited, adj, destination)){
                    return true;
                }
            }
        }
        return false;
    }

}