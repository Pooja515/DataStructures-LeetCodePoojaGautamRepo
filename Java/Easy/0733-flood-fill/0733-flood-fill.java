class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int m = image.length , n= image[0].length;

      int original = image[sr][sc];
      if(original == color) return image;


      dfs(sr,sc,image,original,color,m,n);

      return image;
    }
    int[][] dir ={{-1,0},{1,0},{0,1},{0,-1}};

    void dfs(int r,int c,int[][] image , int original,int color,int m,int n){
        image[r][c] = color;

        for(int[] d:dir){
            int newr = r+d[0] , newc = c+d[1];
            if(newr >= 0 && newr<m && newc>=0 && newc<n && image[newr][newc] == original){
                dfs(newr,newc,image,original,color,m,n);
            }
        }

    }
}