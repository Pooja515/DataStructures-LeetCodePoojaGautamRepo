class Solution {
    Boolean[][] memo ;
    public boolean canPartition(int[] nums) {
      int n = nums.length;
      int totalsum = 0;
      for(int i = 0 ; i < n ;i++){
        totalsum += nums[i];
      }
      if(totalsum % 2 != 0) return false; 
      int target = totalsum/2; 
      memo = new Boolean[n][target+1];
      return f(n-1,target , nums);
    }

    boolean f(int ind , int target , int[] nums){
        if(target == 0) return true;
        if(ind == 0){
          
                return nums[0] == target;
            
        }
        if(memo[ind][target] != null) return memo[ind][target];
        boolean notpick = f(ind-1 , target , nums);
        boolean pick = false;
        if(nums[ind] <= target){
            pick = f(ind-1 , target - nums[ind] , nums);
        }

        return memo[ind][target] = pick || notpick;
    }

}