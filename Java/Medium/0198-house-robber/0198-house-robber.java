class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);

        return f(n - 1, nums,memo);
    }

    int f(int ind, int[] nums , int[] memo) {
        if (ind == 0)
            return nums[ind];
        if (ind == 1)
            return Math.max(nums[0], nums[1]);

        if(memo[ind] != -1) return memo[ind];

        int take = nums[ind] + f(ind - 2, nums,memo);
        int nottake = 0 + f(ind - 1, nums, memo);

        return memo[ind]= Math.max(take, nottake);
    }
}