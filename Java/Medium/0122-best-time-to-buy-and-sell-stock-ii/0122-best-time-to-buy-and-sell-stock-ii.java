class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] prev = new int [2];

        prev[0] =0;
        prev[1] =0;
       
        for(int i = n-1; i >= 0; i--){
              int[] cur = new int [2];
            for(int j = 0; j < 2;j++){
                int  profit =0;
                // buy
                if(j==1){
                 //take
                int take = -prices[i] + prev[0];
                //notTake
                int notTake = 0 + prev[1] ;
                profit = Math.max(take , notTake);
           
            }
        //sell
        else {
                //take
                int take = prices[i] +prev[1];
                //nottake
                int notTake = 0 + prev[0];

                profit = Math.max(take , notTake);
             
            }

          cur[j] = profit;

            }
            prev = cur;
        }

      return prev[1] ;
    }
}