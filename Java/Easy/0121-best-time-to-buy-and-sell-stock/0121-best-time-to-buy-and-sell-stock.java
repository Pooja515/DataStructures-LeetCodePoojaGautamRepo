class Solution {
    public int maxProfit(int[] prices) {
      int buy = Integer.MAX_VALUE , maxi = Integer.MIN_VALUE;
      for(int i=0;i<prices.length;i++){
        buy = Math.min(buy,prices[i]);
        int profit = prices[i]-buy;
        maxi= Math.max(maxi,profit);
      } 

      return maxi; 
    }
}