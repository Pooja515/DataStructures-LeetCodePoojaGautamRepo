class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
          
        for(int ind =2;ind<n;ind++){
           int take = nums[ind] + dp[ind - 2];
           int nottake = 0 + dp[ind - 1];

           dp[ind] = Math.max(take, nottake);
        }

        return dp[n-1];
    }
}