class Solution {
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        memo =new int[n][2][k+1];
        for(int[][] rows:memo){
            for(int[] r:rows){
                Arrays.fill(r,-1);
            }
        }

       return f(0,1,k,prices); 
    }

    int f(int i , int buy,int k,int[] prices){
        if(i== prices.length || k==0) return 0;

        if(memo[i][buy][k] != -1) return memo[i][buy][k];

        if(buy == 1){
            int buytoday= -prices[i] +f(i+1,0,k,prices);
            int skiptoday= 0 +f(i+1,1,k,prices);
            return memo[i][buy][k]=Math.max(buytoday,skiptoday);
        }
        else{
             int selltoday= prices[i] +f(i+1,1,k-1,prices);
            int skipsell= 0 +f(i+1,0,k,prices);
            return memo[i][buy][k]=Math.max(selltoday,skipsell);
        }
    }
}