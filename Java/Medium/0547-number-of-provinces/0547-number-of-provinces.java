class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;
        for(int i = 0;i<n;i++){
             if(!visited[i]){
                dfs(i,isConnected,visited,n);
                province++;
             }
        }
        return province;
    }

    void dfs(int i , int[][] isConnected , boolean[] visited , int n){
        visited[i] = true;
        for(int j = 0 ;j<n ;j++){
            if(!visited[j] && isConnected[i][j] == 1){
                dfs(j,isConnected,visited,n);
            }
        }
    }
}