class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalsum = 0;
        for(int num : nums){
            totalsum += num;
        }

        if(totalsum % 2 != 0) return false;

        int target = totalsum / 2 ;
        int n = nums.length;
        memo = new Boolean[n][target + 1];

       
        return f(n-1 , nums, target);
    }

    boolean f(int ind , int[] nums, int target){
       if(target == 0) return true;
       if(ind < 0) return false;
       if(memo[ind][target] != null) return memo[ind][target];
       boolean notpick = f(ind-1,nums , target);
       boolean pick = false ;
       if(nums[ind] <= target){
         pick = f(ind-1 , nums , target - nums[ind]);
       }

       return memo[ind][target] = pick || notpick;

    }
}