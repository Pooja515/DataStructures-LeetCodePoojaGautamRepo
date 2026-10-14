class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n < 2)
            return Math.min(cost[0], cost[1]);

        int prev2 = cost[0] ,prev1 = cost[1];

        for (int ind = 2; ind < n; ind++) {

            int cur = cost[ind] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = cur;

        }

        return Math.min(prev1,prev2);

    }
}