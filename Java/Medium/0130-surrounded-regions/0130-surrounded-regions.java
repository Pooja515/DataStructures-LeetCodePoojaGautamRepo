class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length ==0) return;
        int m = board.length, n = board[0].length;

        // boundary check for O'S
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board, m, n);
            }
            if (board[r][n - 1] == 'O') {
                dfs(r, n - 1, board, m, n);
            }
        }

         for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board, m, n);
            }
            if (board[m-1][c] == 'O') {
                dfs(m-1, c, board, m, n);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] ='X';
                }
                if(board[i][j] == 'S'){
                    board[i][j] ='O';
                }
            }
        }
    }
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    void dfs(int r,int c,char[][] board,int m,int n){
        board[r][c]='S';

        for(int[] d:dir){
            int newr = r+d[0] , newc=c+d[1];
            if(newr>=0 && newr<m && newc>=0 && newc<n && board[newr][newc] == 'O'){
                dfs(newr,newc,board,m,n);
            }
        }

    }
}