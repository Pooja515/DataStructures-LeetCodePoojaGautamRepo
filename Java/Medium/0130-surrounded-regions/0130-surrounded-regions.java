class Solution {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void solve(char[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                isValid(i, 0, board);
            }
            if (board[i][n - 1] == 'O') {
                isValid(i, n-1, board);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                isValid(0, i, board);
            }
            if (board[m-1][i] == 'O') {
                isValid(m-1, i, board);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                else{
                    if(board[i][j] == 'S'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
    }

    void isValid(int r, int c, char[][] board) {
        board[r][c] = 'S';
        for (int[] d : dir) {
            int newr = r + d[0], newc = c + d[1];
            if (newr >= 0 && newr < board.length && newc >= 0 && newc < board[0].length && board[newr][newc] == 'O') {
                isValid(newr, newc, board);
            }

        }
    }
}