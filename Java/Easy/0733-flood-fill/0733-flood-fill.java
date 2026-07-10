class Solution {
    int[][] dir = {{-1,0},{1,0} , {0,1} , {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        int m= image.length , n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = color;
        q.offer(new int[] {sr,sc});
       
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dir){
                int newr = cur[0] + d[0];
                int newc = cur[1] + d[1];
                if(newr >= 0 && newr < m && newc >= 0 && newc < n && image[newr][newc] == original ){
                   
                    image[newr][newc] = color;
                    q.add(new int[] {newr,newc});
                }
            }
        }
        return image;
    }
}