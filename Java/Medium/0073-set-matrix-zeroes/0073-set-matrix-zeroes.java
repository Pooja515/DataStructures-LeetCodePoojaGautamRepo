class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowflag = false , colflag = false; 
        int m = matrix.length , n = matrix[0].length;
//explore 0 column , (if column 0 has a zero)
        for(int i =0 ; i<m;i++){
            if(matrix[i][0] == 0){
                colflag = true;
                break;
            }
        }
// explore 0 row , (if row 0 has a zero)
        for(int i =0 ; i<n;i++){
            if(matrix[0][i] == 0){
                rowflag = true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1 ; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] =0;
                    matrix[0][j] =0;
    
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1 ; j<n; j++){
                if( matrix[i][0] ==0 || matrix[0][j] ==0){
                    matrix[i][j] =0;
                }
            }
        }
// if row 0 has 0 , make entire row 0 to 0
        if(rowflag){
            for(int i =0 ; i<n ;i++){
                matrix[0][i] =0;
            
            }
        }
// if col 0 has 0 , make entire col 0 to 0
         if(colflag){
            for(int i =0 ; i<m ;i++){
                matrix[i][0] =0;
            
            }
        }
    }
}
