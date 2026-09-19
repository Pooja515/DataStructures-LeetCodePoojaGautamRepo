class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        memo= new int[n+1];
        Arrays.fill(memo,-1);
        
        if(n<2) return Math.min(cost[0],cost[1]);
       

        return f(n,cost);
    }
    int f(int i,int[] cost){
        if(i<=1) return 0;

        if(memo[i] != -1) return memo[i];

        int jump1 = cost[i-1] + f(i-1,cost);
        int jump2 = cost[i-2] + f(i-2,cost);

        return  memo[i] = Math.min(jump1,jump2);
    }

}