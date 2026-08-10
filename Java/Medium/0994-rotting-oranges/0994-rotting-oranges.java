class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid== null || grid.length ==0) return 0;

        int m = grid.length, n = grid[0].length;
    
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2 ) {
                    q.offer(new int[] { r, c });
                } else {
                    if (grid[r][c] == 1)
                        fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int minute =0;
        while (!q.isEmpty() && fresh > 0) {
             int size = q.size();
             minute ++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dir) {
                    int newr = curr[0] + d[0], newc = curr[1] + d[1];
                    if (newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        grid[newr][newc] = 2;
                        q.offer(new int[] { newr, newc });
                        fresh--;
                    }
                }

            }

        }

        return (fresh == 0 ? minute : -1);

    }
}