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

    boolean f(int i , int[] nums, int target){
        if(target == 0) return true;
        if(i == 0)
           return (nums[i] == target);
          if (memo[i][target] != null) {
            return memo[i][target];
        }
        boolean nottake = f(i-1 , nums , target);
        boolean take = false;
        if(nums[i] <= target){
            take = f(i-1 , nums , target - nums[i]);
        }
         return memo[i][target] =  nottake || take;
    }
}