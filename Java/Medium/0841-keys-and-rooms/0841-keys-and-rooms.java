class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0,visited,rooms);
        for(int i=0;i<rooms.size();i++){
            if(visited[i] == false) 
                 return false;
            }
          return true;
    }
    void dfs(int node , boolean[] visited,List<List<Integer>> rooms){
        visited[node] = true;
        for(int neighbors : rooms.get(node)){
            if(!visited[neighbors]){
                dfs(neighbors,visited,rooms);
            }
        }
    }
  
}