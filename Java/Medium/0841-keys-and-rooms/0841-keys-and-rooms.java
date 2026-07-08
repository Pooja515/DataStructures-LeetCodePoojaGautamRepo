class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         int n = rooms.size();
         boolean[] visited = new boolean[n];
        
         dfs(0,rooms,visited,n);
            
         for(boolean vis : visited){
            if(!vis) return false;
         }
         return true;
    }
    void dfs(int i, List<List<Integer>> rooms , boolean[] visited , int n){
        visited[i] = true;
        for(int nei : rooms.get(i)){
            if(!visited[nei]){
                dfs(nei,rooms,visited,n);
            }
        }
    }
}