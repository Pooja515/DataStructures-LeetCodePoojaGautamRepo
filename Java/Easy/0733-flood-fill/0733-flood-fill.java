class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int originalcolor = image[sr][sc];
       if(originalcolor == color) return image;
       dfs(sr,sc,image,color,originalcolor);

       return image;
    }
    void dfs(int r , int c, int[][] image , int color , int originalcolor){
        image[r][c] = color;
        for(int[] d : dir){
            int newr = r+d[0] , newc=c+d[1];
            if(newr >= 0 && newr < image.length && newc >= 0 && newc < image[0].length && image[newr][newc] == originalcolor){
                dfs(newr,newc,image,color,originalcolor);
            }
        }
    }
}