class Solution {
    Boolean[][] memo ;
    public boolean canPartition(int[] nums) {

        int n = nums.length, totalsum = 0;

        for (int i = 0; i < n; i++) {
            totalsum += nums[i];
        }
        if (totalsum % 2 != 0)
            return false;

        int target = totalsum / 2;

         memo = new Boolean [n][target+1];


        return f(n - 1, target, nums);
    }

    boolean f(int i, int target, int[] nums) {
        if (target == 0){
             return true;
        }
        if(i == 0){
            if(nums[i] <= target ) return target == nums[i];
            else
                 return false;
        }
    
    if(memo[i][target] != null) return memo[i][target];
    boolean nottake = f(i - 1, target, nums);
    boolean take = false;
    if(nums[i] <= target){
        take = f(i - 1, target - nums[i], nums);
    }

    return memo[i][target] = take||nottake;

}
}