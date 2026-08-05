class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;

        boolean[] visited = new boolean[m];
        int province =0;
        for(int i=0;i<m;i++){
            if(!visited[i]){
                dfs(i,visited,isConnected);
                province++;
            }
        }
        return province;
    }

    void dfs(int city ,boolean[] visited , int[][] isConnected){
        visited[city]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[city][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }
    }
}