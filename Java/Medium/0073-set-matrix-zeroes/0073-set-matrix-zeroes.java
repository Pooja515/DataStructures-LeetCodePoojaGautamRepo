class Solution {
    public void setZeroes(int[][] matrix) {
        int m= matrix.length, n= matrix[0].length;

        boolean rowflag= false , colflag =false;

        for(int r=0;r<m;r++){
            if(matrix[r][0] == 0 ) {
                colflag =true;
                break;
            }
        }
        for(int c=0;c<n;c++){
            if(matrix[0][c] == 0) {
                rowflag =true;
                break;
            }
        }
        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                if(matrix[r][c] == 0){
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                if(matrix[0][c] ==0 || matrix[r][0] ==0){
                    matrix[r][c] =0;
                }
            }
        }

        if(rowflag){
            for(int c=0;c<n;c++){
                matrix[0][c] =0;
            }
        }
         if(colflag){
            for(int r=0;r<m;r++){
                matrix[r][0] =0;
            }
        }
    }
}