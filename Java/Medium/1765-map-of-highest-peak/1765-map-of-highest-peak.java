class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isWater[r][c] == 1) {
                    q.offer(new int[] { r, c });
                    isWater[r][c] = 0;
                }
                else{
                    isWater[r][c] = -1;
                }
            }
        }
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dir){
                int newr = cur[0] + d[0];
                int newc = cur[1] + d[1];

                if(newr >= 0 && newr < m && newc >= 0 && newc < n &&  isWater[newr][newc] == -1){
                    isWater[newr][newc] = isWater[cur[0]][cur[1]] + 1;
                    q.offer( new int[] { newr , newc});
                }
            }
        }
        return isWater;
    }
}