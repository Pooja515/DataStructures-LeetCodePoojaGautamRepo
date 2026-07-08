class Solution {
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        memo = new int[n][2][k+1];
        for(int[][] row : memo){
            for(int r[] : row){
                Arrays.fill(r , -1);
            }
        }

        return f(0,1,k, prices,n);
    }
    int f(int ind ,int buy, int k , int[] prices, int n){
        if(ind == n || k == 0 ) return 0;

        if(memo[ind][buy][k] != -1){
            return memo[ind][buy][k];
        }

        if(buy == 1){
            int buyToday = -prices[ind] + f(ind+1 , 0 , k, prices , n);
            int skipBuy = 0 + f(ind+1 , 1 , k , prices ,n);
            return memo[ind][buy][k] =Math.max(buyToday,skipBuy);
        }
        else{
             int sellToday = prices[ind] + f(ind+1 , 1 , k-1, prices , n);
            int holdSell = 0 + f(ind+1 , 0 , k , prices ,n);
            return memo[ind][buy][k] = Math.max(sellToday,holdSell);
        }
    }
}