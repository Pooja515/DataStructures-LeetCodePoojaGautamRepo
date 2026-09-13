class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

         dfs(0,rooms,visited);
         for(boolean num : visited){
            if(!num) return false;
         }
         return true;
    }

    void dfs(int node ,List<List<Integer>> rooms, boolean[] visited ){
        visited[node] = true;
        for(int neigh : rooms.get(node)){
            if(!visited[neigh]) dfs(neigh,rooms,visited);
        }
    }
}