class Solution {
   
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;

        if(n==0 || k==0) return 0;
        int[][] dp =new int [2][k+1];

        for(int i=n-1;i>=0;i--){
             int[][] cur =new int [2][k+1];
            for(int j=1;j<=k;j++){
               int selltoday= prices[i] +dp[1][j-1];
               int skipsell= 0 +dp[0][j];
               cur[0][j]=Math.max(selltoday,skipsell);

                int buytoday= -prices[i] +dp[0][j];
                int skiptoday= 0 +dp[1][j];
                cur[1][j]=Math.max(buytoday,skiptoday);
            }
            dp=cur;
        }
      return dp[1][k];
    }
}