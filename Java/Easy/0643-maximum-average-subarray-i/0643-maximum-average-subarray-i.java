class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int l=0 ;
       double sum = 0 , maxi =  Double.NEGATIVE_INFINITY;
       for(int r=0;r<nums.length;r++){
        sum +=nums[r];
        if(r-l+1 == k){
            double avg = sum/k;
            maxi = Math.max(maxi , avg);
            sum -= nums[l];
            l++;
        }
       } 
       return maxi;
    }
}