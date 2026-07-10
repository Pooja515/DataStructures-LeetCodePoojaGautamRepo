class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int province = 0;
        for(int i = 0 ;i<n ;i++){
            if(!visited[i]){
                province++;
                Queue<Integer> q = new ArrayDeque<>();
                q.offer(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int nei =0;nei<n;nei++){
                        if(isConnected[node][nei] == 1 && !visited[nei]){
                            visited[nei] = true;
                            q.offer(nei);
                        }
                    }
                }
            }
        }
        return province;
    }
}