class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] cur = new int[n];

        for(int i=0 ;i<m ;i++){
            for(int j =0;j<n ;j++){
                 if (i == 0 && j == 0){
                     cur[j] = grid[i][j];
                     continue;
                 }

            int up = (int) 1e9;
            int left = (int) 1e9;
    
            if (i > 0) up = cur[j];
            if (j > 0) left = cur[j - 1];

            cur[j] = grid[i][j] + Math.min(up, left);
         }
             
     }
    return cur[n-1];
    }
}