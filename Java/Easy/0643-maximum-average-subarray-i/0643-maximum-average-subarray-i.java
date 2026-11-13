class Solution {
    public double findMaxAverage(int[] nums, int k) {
       double maxavg = Double.NEGATIVE_INFINITY;
       int l=0 ;
       double sum=0;
       for(int r=0;r<nums.length;r++) {
          sum += nums[r];
          if(r-l+1 == k){
            maxavg = Math.max(maxavg,sum);
            sum -= nums[l];
            l++;
          }
        
       }
       return maxavg/k ;
    }
}