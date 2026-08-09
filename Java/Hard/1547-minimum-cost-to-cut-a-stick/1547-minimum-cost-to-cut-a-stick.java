class Solution {

    int[][] memo;

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        int[] arr = new int[m + 2];

        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        memo = new int[m + 2][m + 2];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return findMinimumCost(1, m, arr);
    }

    public int findMinimumCost(int i, int j, int[] cuts) {

        if (i > j) {
            return 0;
        }

        // Already calculated
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int mini = (int) 1e9;

        for (int ind = i; ind <= j; ind++) {

            int cost = cuts[j + 1] - cuts[i - 1]
                     + findMinimumCost(i, ind - 1, cuts)
                     + findMinimumCost(ind + 1, j, cuts);

            mini = Math.min(mini, cost);
        }

        return memo[i][j] = mini;
    }
}