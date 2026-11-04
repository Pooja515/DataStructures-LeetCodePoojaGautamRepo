class Solution {
    public int maxSubArray(int[] nums) {
        int sum =0,maxsum=Integer.MIN_VALUE;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            maxsum = Math.max(maxsum,sum);

            if(sum<0) sum=0;
        }
        return maxsum;
    }
}