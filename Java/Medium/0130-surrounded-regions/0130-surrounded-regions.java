class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board, m, n);
            }
            if (board[r][n - 1] == 'O') {
                dfs(r, n - 1, board, m, n);
            }
        }
        // column
        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board, m, n);
            }
            if (board[m - 1][c] == 'O') {
                dfs(m - 1, c, board, m, n);
            }
        }

        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
                else{
                    if(board[r][c] == 'S'){
                    board[r][c] = 'O';
                }
                }
                
            }
        }

    }
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    void dfs(int r,int c , char[][] board , int m , int n ){
        board[r][c] ='S';
        for(int[] d:dir){
            int newr = r+d[0] , newc = c+d[1];
            if(newr >= 0 && newr < m && newc >= 0 && newc < n && board[newr][newc] == 'O'){
                dfs(newr,newc,board,m,n);
            }
        }

    }
}