class Solution {
    int[][][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2][3];
        for(int[][] rows:memo){
            for(int[] r:rows){
                Arrays.fill(r,-1);
            }
        }

        return f(0,1,prices,2);
    }

    int f(int i,int buy,int[] prices,int k){
        if(i==prices.length || k==0)  return 0;

        if(memo[i][buy][k] != -1) return memo[i][buy][k];

        if(buy==1){
            int buytoday =  -prices[i] + f(i+1,0,prices,k);
            int skiptoday = 0 + f(i+1,1,prices,k);
            return  memo[i][buy][k]=Math.max(buytoday,skiptoday);
        }
        else{
            int selltoday = prices[i] + f(i+1,1,prices,k-1);
            int skip = 0 + f(i+1,0,prices,k);
            return  memo[i][buy][k]=Math.max(selltoday,skip);
        }

    }
}