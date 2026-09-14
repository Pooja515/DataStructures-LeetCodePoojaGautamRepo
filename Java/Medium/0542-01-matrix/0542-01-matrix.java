class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length , n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(mat[r][c] == 0){
                    q.offer(new int[]{r,c});
                }
                else{
                    mat[r][c] = -1;
                }
            }
        }
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0] , c= curr[1];
            for(int[] d: dir){
                int newr = r+d[0] , newc = c+d[1];
                if(newr >= 0 && newr < m && newc >= 0 && newc < n &&  mat[newr][newc] == -1){
                    mat[newr][newc] = mat[r][c] + 1;
                    q.offer(new int[]{newr,newc});
                }
            }
        }
        return mat;
    }
}