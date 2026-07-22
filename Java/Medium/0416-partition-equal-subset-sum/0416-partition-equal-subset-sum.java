class Solution {
    
    public boolean canPartition(int[] nums) {
        int totalsum = 0;
        for(int num : nums){
            totalsum += num;
        }

        if(totalsum % 2 != 0) return false;

        int target = totalsum / 2 ;
        int n = nums.length;

        boolean[][] dp = new boolean [n][target + 1];

          for(int ind = 0 ;ind < n; ind++){
            dp[ind][0] = true;
          }

       for(int ind = 1 ;ind < n; ind++){
        for(int t = 1 ;t <= target ; t++){
            
            boolean notpick = dp[ind-1][t];
            boolean pick = false ;
            if(nums[ind] <= t){
                pick = dp[ind-1][t - nums[ind]];
            }
             dp[ind][t] = pick || notpick;
        }
      
    
       }
    
    return dp[n-1][target];
    }
}