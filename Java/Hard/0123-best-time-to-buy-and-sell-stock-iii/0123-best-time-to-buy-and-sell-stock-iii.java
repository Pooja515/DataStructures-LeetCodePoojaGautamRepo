class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int [2][3];
        for(int ind= n-1 ; ind >= 0 ; ind--){
            int[][] cur = new int [2][3];
            for(int trans = 1;trans <= 2 ; trans++ ){
                cur[0][trans] = Math.max(prices[ind] + dp[1][trans-1] , dp[0][trans]);
                cur[1][trans] = Math.max(-prices[ind] + dp[0][trans] , dp[1][trans]);
            }
            dp = cur;
        }
        return dp[1][2];
    }
}