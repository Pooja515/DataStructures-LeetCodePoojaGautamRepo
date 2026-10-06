class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adj = new ArrayList<>();
         for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
         }
         int[] indegree = new int[numCourses];

         for(int[] edge:prerequisites ){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
         }

         Queue<Integer> q =new LinkedList<>();

          for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

         int ind=0;

         while(!q.isEmpty()){
            int node = q.poll();
            ind++;
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] ==0){
                    q.offer(neigh);
                }
            }
             if(ind == numCourses) return true;

         }
        
         return false;
    }
}