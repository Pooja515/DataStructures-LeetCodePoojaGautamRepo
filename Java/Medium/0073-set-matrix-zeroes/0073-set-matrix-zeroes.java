class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;

        boolean rowflag = false , colflag = false;
        //explore row 
        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
               colflag = true;
               break;
            }
        }

        // explore col
         for(int i=0;i<n;i++){
            if(matrix[0][i] == 0){
               rowflag = true;
               break;
            }
           
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0){
                     matrix[0][j] = 0;
                     matrix[i][0] = 0;
                }

            }
        }

         for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                     matrix[i][j] = 0;
                
                }

            }
        }

        if(rowflag){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }

        if(colflag){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}