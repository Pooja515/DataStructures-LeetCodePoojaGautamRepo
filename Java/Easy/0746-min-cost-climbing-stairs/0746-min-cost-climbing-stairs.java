class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        return f(n, cost, memo);
    }

    int f(int ind, int[] cost, int[] memo) {

        if (ind <= 1)
            return 0;

        if (memo[ind] != -1)
            return memo[ind];

        int climb1 = f(ind - 1, cost, memo) + cost[ind - 1];
        int climb2 = Integer.MAX_VALUE;
        if (ind > 1) {
            climb2 = f(ind - 2, cost, memo) + cost[ind - 2];
        }

        return memo[ind] = Math.min(climb1, climb2);
    }
}