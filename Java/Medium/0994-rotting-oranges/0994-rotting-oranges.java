class Solution {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] { r, c });
                } else {
                    if (grid[r][c] == 1)
                        fresh++;
                }
            }
        }
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                for (int[] d : dir) {
                    int newr = cur[0] + d[0];
                    int newc = cur[1] + d[1];
                    if (newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        fresh--;

                        grid[newr][newc] = 2;
                        q.offer(new int[] { newr, newc });
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}