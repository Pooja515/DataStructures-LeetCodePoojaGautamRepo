class Solution {
    int[][] memo;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] rows : memo){
            Arrays.fill(rows,-1);
        }

        return f(0,1,fee,prices);
    }

    int f(int i , int buy , int fee,int[] prices){
        if( i == prices.length) return 0;

        if(memo[i][buy] != -1) return memo[i][buy];

        if(buy == 1){
            int buytoday = -prices[i] + f(i+1,0,fee,prices);
            int skipbuy = 0 + f(i+1,1,fee,prices);

            return memo[i][buy] = Math.max(buytoday, skipbuy);
        }
        else{
            int selltoday = prices[i] + f(i+1,1,fee,prices) - fee;
            int skipsell = 0 + f(i+1,0,fee,prices);
            return memo[i][buy]=Math.max(selltoday,skipsell);
        }
    }
}