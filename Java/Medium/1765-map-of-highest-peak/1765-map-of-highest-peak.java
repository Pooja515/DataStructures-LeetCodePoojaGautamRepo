class Solution {
    public int[][] highestPeak(int[][] isWater) {
        if (isWater == null || isWater.length == 0)
            return isWater;
        Queue<int[]> q = new LinkedList<>();
        int rows = isWater.length, cols = isWater[0].length;
        int distance = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    isWater[i][j] = 0; // Important
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] d : directions) {
                int newr = r + d[0];
                int newc = c + d[1];
                if (newr >= 0 && newr < rows && newc >= 0 && newc < cols && isWater[newr][newc] == -1) {
                    isWater[newr][newc] = isWater[r][c] + 1;
                    q.offer(new int[] { newr, newc });
                }
            }
        }

        return isWater;
    }
}
