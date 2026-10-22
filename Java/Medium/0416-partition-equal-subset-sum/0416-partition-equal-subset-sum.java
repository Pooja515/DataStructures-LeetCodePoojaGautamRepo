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

        int[][] memo = new int[n][target + 1];
        for (int[] rows : memo) {
            Arrays.fill(rows, -1);
        }

        return f(n - 1, target, nums, memo);
    }

    boolean f(int i, int target, int[] nums, int[][] memo) {
        if (target == 0)
            return true;

        if (i == 0)
            return nums[0] == target;

        if (memo[i][target] != -1)
            return memo[i][target] == 1;

        boolean nottake = f(i - 1, target, nums, memo);
        boolean take = false;
        if (nums[i] <= target) {
            take = f(i - 1, target - nums[i], nums, memo);
        }

        memo[i][target] = take || nottake ? 1 : 0;

        return take || nottake;

    }
}