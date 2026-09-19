class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n < 2)
            return Math.min(cost[0], cost[1]);

      
        int prev2 = cost[0];
        int prev1 = cost[1] ;

        for (int i = 2; i < n; i++) {
          

            int cur =cost[i]+ Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = cur;

        }
        return Math.min(prev2,prev1);

    }

}