class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        boolean[] dp = new boolean [target + 1];

        for (int i = 0; i < n; i++) {
            dp[0] = true;
        }

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
             boolean[] cur = new boolean [target + 1];
             cur[0] = true;
             for (int t = 0; t <= target; t++) {

                boolean nottake = dp[t];
                boolean take = false;
                if (nums[i] <= t) {
                    take = dp[t - nums[i]];
                }

                cur[t] = take || nottake;
            }
            dp=cur;
        }
        return dp[target];

    }
}