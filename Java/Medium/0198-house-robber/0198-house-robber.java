class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
      
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int ind = 2; ind < n; ind++) {
            int take = nums[ind] + prev2;
            int nottake = 0 + prev1;

            int cur = Math.max(take, nottake);

            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}