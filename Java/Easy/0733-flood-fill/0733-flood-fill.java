class Solution {
    int[][] dir = {{-1,0},{1,0} , {0,1} , {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        int m= image.length , n = image[0].length;
        dfs(sr,sc,image,color,original);
        return image;
    }
    void dfs(int sr, int sc , int[][] image , int color , int original){
         int m= image.length , n = image[0].length;
            image[sr][sc] = color;
      
            for(int[] d : dir){
                int newr = sr + d[0];
                int newc = sc + d[1];
                if(newr >= 0 && newr < m && newc >= 0 && newc < n && image[newr][newc] == original ){
                   
                     dfs(newr,newc,image,color,original);
                    
                }
            }
        }
    }
