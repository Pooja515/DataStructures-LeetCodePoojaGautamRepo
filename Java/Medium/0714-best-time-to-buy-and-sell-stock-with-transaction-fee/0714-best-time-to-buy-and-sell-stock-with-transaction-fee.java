class Solution {
   
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
         int[] cur = new int[2];
         cur[0] =0;
         cur[1] =0;
       
         for(int i=n-1;i>=0;i--){
          
            cur[0]= Math.max(prices[i] + cur[1] - fee ,cur[0]);
            cur[1]= Math.max(-prices[i] + cur[0] ,cur[1]);
    
         }
        return cur[1];
    }
}