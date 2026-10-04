class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

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

        if (fresh == 0)
            return 0;

        int minute = 0;
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            minute++;

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int[] d : dir) {
                    int newr = r + d[0], newc = c + d[1];
                    if (newr >= 0 && newr < m && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        grid[newr][newc] = 2;
                        fresh--;
                        q.offer(new int[] { newr, newc });
                    }
                }
            }

        }
        return fresh == 0 ? minute : -1;

    }
}