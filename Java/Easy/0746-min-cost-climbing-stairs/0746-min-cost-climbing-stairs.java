class Solution {
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n<2) return Math.min(cost[0],cost[1]);
        
        int prev2 =0 , prev1=0;

       for(int i = 2;i<=n;i++){
           int climb1 = prev1+ cost[i-1];
           int climb2 = prev2 + cost[i-2];

          int cur = Math.min(climb1 , climb2);
          prev2  = prev1;
          prev1 = cur;
       }
       return prev1;
    }
}