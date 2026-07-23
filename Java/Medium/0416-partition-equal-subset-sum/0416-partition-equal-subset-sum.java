class Solution {

    public boolean canPartition(int[] nums) {
      int n = nums.length;
      int totalsum = 0;
      for(int i = 0 ; i < n ;i++){
        totalsum += nums[i];
      }
      if(totalsum % 2 != 0) return false; 
      int target = totalsum/2; 
       boolean[][] dp = new boolean[n][target+1];
     
        for(int i = 0 ; i<n ; i++){
            dp[i][0] = true;
        }
       
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        
        
        
        for(int ind = 1 ;ind < n ;ind++){
            for(int t =1; t<= target;t++){
                boolean notpick = dp[ind-1][t];
                boolean pick = false;
                if(nums[ind] <= t){
                    pick = dp[ind-1][t - nums[ind]];
                }

                dp[ind][t] = pick || notpick;
            }
        }

        return dp[n-1][target];
    }

}