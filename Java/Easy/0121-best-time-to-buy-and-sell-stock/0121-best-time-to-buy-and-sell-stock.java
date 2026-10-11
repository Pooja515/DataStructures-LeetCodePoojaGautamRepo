class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0],n = prices.length , maxi = 0;

         for(int i=1;i<n;i++){
            buy= Math.min(buy,prices[i]);
            int profit = prices[i]-buy;

            maxi= Math.max(maxi,profit);
         }
         return maxi;
    }
}