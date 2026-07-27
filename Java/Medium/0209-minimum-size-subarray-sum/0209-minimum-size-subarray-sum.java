class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, minlen = Integer.MAX_VALUE, sum=0;
        for(int r = 0 ; r < nums.length ; r++){
           sum += nums[r];
           while(sum >= target){
            minlen = Math.min(r-l+1 , minlen);
             sum -= nums[l];
             l++;   
           }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}