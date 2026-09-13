class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited,n);
                province++;
            }
        }
        return province;
    }

    void dfs(int node, int[][] isConnected, boolean[] visited,int n) {
        visited[node] = true;
        for (int j = 0; j < n; j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited,n);
            }
        }
    }
}