class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null) return null;
        int m = image.length , n = image[0].length;
        int newcolor = image[sr][sc];

        if(newcolor == color ) return image ;
            
        dfs(sr,sc,image,color,newcolor);

        return image;
    }

    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    void dfs(int sr,int sc ,int[][] image,int color, int newcolor){
        image[sr][sc] = color;
        
        for(int[] d:dir){

            int newr = sr + d[0] , newc = sc + d[1];

            if(newr >= 0 && newr < image.length && newc >= 0 && newc < image[0].length && image[newr][newc] == newcolor){
                
                dfs(newr,newc,image,color,newcolor);
            }
        }

    }
}