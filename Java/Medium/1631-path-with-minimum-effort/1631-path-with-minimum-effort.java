class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        //PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq =new PriorityQueue<>((a, b) ->Integer.compare(a[0],b[0]));
        int[][] distance = new int[n][m];
        for(int[] row : distance){
                Arrays.fill(row,(int) 1e9);
        }

       distance[0][0] = 0; // source (0,0) =0;

       pq.offer(new int[] {0,0,0}); // pair {distance , r,c};

       int[][] dir = {{-1,0} ,{1,0} ,{0,-1} ,{0,1}}; // 4 directions

       while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int currdistance = curr[0];
        int r = curr[1];
        int c = curr[2];

        if(r == n-1 && c == m-1){
            return currdistance;
        }

        for(int[] d :dir){
            int newr = r+d[0] , newc = c+d[1];
            if(newr >= 0 && newr < n && newc >= 0 && newc < m ){
                int newdistance = Math.max(Math.abs(heights[r][c] - heights[newr][newc]),currdistance );

                if(newdistance < distance[newr][newc]){
                    distance[newr][newc] = newdistance;
                    pq.offer(new int[]{newdistance , newr , newc});
                }
            }
        }

       }
       return 0;
    }
}