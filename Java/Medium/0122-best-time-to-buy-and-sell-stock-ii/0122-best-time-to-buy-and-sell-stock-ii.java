class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        memo = new int[n][2];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }
        return f(0, 1, prices, n);
    }

    int f(int ind, int buy, int[] prices, int n) {
        //BASE CASE 
        if (ind == n)
            return 0;
        
        if(memo[ind][buy] != -1) return memo[ind][buy];

        if (buy == 1) {
            int buytoday = -prices[ind] + f(ind + 1, 0, prices, n);
            int notBuytoday = 0 + f(ind + 1, 1, prices, n);
            return  memo[ind][buy] = Math.max(buytoday, notBuytoday);

        } else {
            int selltoday = prices[ind] + f(ind + 1, 1, prices, n);
            int notSelltoday = 0 + f(ind + 1, 0, prices, n);
            return memo[ind][buy] = Math.max(selltoday, notSelltoday);
        }
    }
}