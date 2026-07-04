class Solution {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }

        return f(0 , 1, prices,n);

    }
    int  f(int ind ,int  buy , int[] prices , int n){
        if(ind == n) return 0;
        int  profit =0;
        if(memo[ind][buy] != -1) return memo[ind][buy];
        if(buy ==1){
            //take
            int take = -prices[ind] +f(ind+1 , 0, prices ,n);
            int notTake = 0 + f(ind + 1 , 1 , prices , n);
            profit = Math.max(take , notTake);
           
        }
        else {
              //take
            int take = prices[ind] +f(ind+1 , 1 , prices , n);
            int notTake = 0 + f(ind + 1 , 0 , prices , n);
           profit = Math.max(take , notTake);
           memo[ind][buy] = profit;
        }
        return   memo[ind][buy] = profit;
    }
}