class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int minutes = 0, fresh = 0;
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
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] d : dirs) {
                    int newr = d[0] + cur[0];
                    int newc = d[1] + cur[1];

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