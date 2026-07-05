class Solution {
    int[][] memo ;
    public int maxProfit(int[] prices) {
       int n = prices.length;
       memo = new int[n][2];
       for(int[] r:memo){
        Arrays.fill(r , -1);
       }

       return f(0,1,prices,n); 
    }
    int f(int ind , int buy , int[] prices , int n){
        if(ind == n) return 0;
        if(memo[ind][buy] != -1) return memo[ind][buy];
        //buy
        if(buy == 1){
            int take = -prices[ind] + f(ind + 1 , 0 , prices , n);
            int nottake = 0 + f(ind + 1 , 1, prices , n);
            int profit = Math.max(take , nottake);
            return memo[ind][buy]=profit;
        }
        //sell
        else{
            int take = prices[ind] + f(ind + 1 , 1 , prices , n);
            int nottake = 0 + f(ind + 1 , 0, prices , n);
            int profit = Math.max(take , nottake);
            return memo[ind][buy]= profit;
        }
        
    }
}