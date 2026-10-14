class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if(n<2) return Math.min(cost[0],cost[1]);

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int ind=2;ind<=n;ind++){
           int climb1 = dp[ind - 1]+ cost[ind - 1];
           int climb2 = dp[ind - 2] + cost[ind - 2];
    
           dp[ind] = Math.min(climb1, climb2);

        }

        return dp[n];
        
    }
}