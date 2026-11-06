class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
         List<Integer> ans = new ArrayList<>();
         int m = matrix.length , n = matrix[0].length;
         int left=0, right = n-1;
         int top=0, bottom = m-1;

         while(left <= right && top <= bottom){
            //left to right
            for(int i = left ;i <= right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //top to bottom
            for(int i=top;i <= bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            //right to left
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
         }
         //bottom to top
         if(left <= right){
            for(int i=bottom;i>=top;i--){
                ans.add(matrix[i][left]);
            }
         }
            left++;
         }
         return ans;
    }
}