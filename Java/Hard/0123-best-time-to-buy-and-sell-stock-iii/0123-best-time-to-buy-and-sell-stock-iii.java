class Solution {
    int[][][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;

        memo = new int[n][2][3];
        for(int[][] row : memo){
            for(int[] r: row){
                Arrays.fill(r , -1);
            }
        }
        return f(0, 1, 2, prices, n);
    }

    int f(int ind, int buy, int trans, int[] prices, int n) {
        if (ind == n || trans == 0)
            return 0;
        if(memo[ind][buy][trans] != -1){
            return memo[ind][buy][trans];
        }
        if (buy == 1) {
            int buytoday = -prices[ind] + f(ind + 1, 0, trans, prices, n);
            int skipbuy = 0 + f(ind + 1, 1, trans, prices, n);

            return memo[ind][buy][trans] = Math.max(buytoday, skipbuy);

        }

        else {
            int selltoday = prices[ind] + f(ind + 1, 1, trans - 1, prices, n);
            int holdsell = 0 + f(ind + 1, 0, trans, prices, n);

            return memo[ind][buy][trans]= Math.max(selltoday, holdsell);

        }
    }
}