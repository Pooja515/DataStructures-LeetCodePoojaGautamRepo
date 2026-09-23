class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length, totalsum = 0;
        for (int num : nums) {
            totalsum += num;
        }

        if (totalsum % 2 != 0) {
            return false;
        }

        int target = totalsum / 2;
        memo =new int[n][target+1];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }

        return f(n - 1, target, nums);
    }
    boolean f(int i , int target,int[] nums){
        if(target == 0) return true;
        if(i<0) return false;

        if(memo[i][target] !=-1) return memo[i][target] == 1;

        boolean notpick = f(i-1,target,nums);
        boolean pick = false;
        if(nums[i] <= target)
            pick = f(i-1,target - nums[i],nums);

        memo[i][target]=pick || notpick ? 1:0; 

        return pick || notpick; 
    }
}