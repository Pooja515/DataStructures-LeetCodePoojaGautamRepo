class Solution {

    public boolean canPartition(int[] nums) {

        int n = nums.length, totalsum = 0;

        for (int i = 0; i < n; i++) {
            totalsum += nums[i];
        }
        if (totalsum % 2 != 0)
            return false;

        int target = totalsum / 2;

        boolean [][] dp = new boolean [n][target+1];

        for(int i =0;i<n;i++){
            dp[i][0] = true;
        }

        if(n==1){
            if(nums[0] <= target) return dp[0][nums[0]];
            else
                  dp[0][target] = false;
        }
    
    for(int i=1;i<n;i++){
        for(int t=0;t<= target;t++){
              boolean nottake = dp[i - 1][t];
              boolean take = false;
              if(nums[i] <= t){
                 take = dp[i - 1][t - nums[i]];
                }

               dp[i][t] = take||nottake;
        }
    }
  
     return dp[n-1][target];
    }
}