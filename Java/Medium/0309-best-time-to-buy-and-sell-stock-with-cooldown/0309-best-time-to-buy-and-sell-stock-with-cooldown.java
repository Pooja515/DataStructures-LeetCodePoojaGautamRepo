class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }
       
       return f(0,1,prices);
    }

    int f(int ind , int buy ,int[] prices){
        if(ind >= prices.length) return 0;

        if(memo[ind][buy] != -1) return memo[ind][buy];

        if(buy == 1){
            int buytoday = -prices[ind] + f(ind+1,0,prices);
            int skipbuy =  f(ind+1 , 1,prices);
            return memo[ind][buy] = Math.max(buytoday , skipbuy);
        }
        else{
            int selltoday = prices[ind] + f(ind+2,1,prices);
            int skipsell = f(ind+1,0,prices);
            return memo[ind][buy] = Math.max( selltoday ,skipsell );
        }
    }
}