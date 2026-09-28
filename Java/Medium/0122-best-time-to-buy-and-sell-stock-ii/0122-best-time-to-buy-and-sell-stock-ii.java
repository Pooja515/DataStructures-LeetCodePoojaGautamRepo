class Solution {
    int[][] memo ;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }
        return f(0,1,prices);
    }
    int f(int i, int buy,int[] prices){
        if(i == prices.length) return 0;

        if(memo[i][buy] != -1) return memo[i][buy];

        if(buy==1){
            int buytoday = -prices[i]+f(i+1,0,prices);
            int notbuy= 0+  f(i+1,1,prices);
            return memo[i][buy]=Math.max(buytoday,notbuy);
        }
       else{
            int selltoday = prices[i]+f(i+1,1,prices);
            int notsell= 0+  f(i+1,0,prices);
            return memo[i][buy]=Math.max(selltoday,notsell);
       }
    }
}