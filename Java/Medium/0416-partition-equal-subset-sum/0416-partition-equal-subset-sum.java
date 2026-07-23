class Solution {

    public boolean canPartition(int[] nums) {
      int n = nums.length;
      int totalsum = 0;
      for(int i = 0 ; i < n ;i++){
        totalsum += nums[i];
      }
      if(totalsum % 2 != 0) return false; 
      int target = totalsum/2; 
       boolean[] dp = new boolean[target+1];
     
        for(int i = 0 ; i<n ; i++){
            dp[0] = true;
        }
       
        if(nums[0] <= target){
            dp[nums[0]] = true;
        }
        
        
        
        for(int ind = 1 ;ind < n ;ind++){
              boolean[] cur = new boolean[target+1];
            for(int t =1; t<= target;t++){
                boolean notpick = dp[t];
                boolean pick = false;
                if(nums[ind] <= t){
                    pick = dp[t - nums[ind]];
                }

                cur[t] = pick || notpick;
            }
            dp = cur;
        }

        return dp[target];
    }

}