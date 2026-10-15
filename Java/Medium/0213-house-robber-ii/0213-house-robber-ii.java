class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] memo1 = new int[n];
        Arrays.fill(memo1,-1);

        int[] memo2 = new int[n];
        Arrays.fill(memo2,-1);


        int excludeLast = f(n - 2, 0, nums,memo1);

        int excludeFirst = f(n - 1, 1, nums,memo2);

        return Math.max(excludeLast, excludeFirst);
    }

    int f(int i, int start, int[] nums , int[] memo) {
        if (i < start)
            return 0;
        if (i == start)
            return nums[start];
        if(memo[i] != -1) return memo[i];

        int pick = nums[i] + f(i - 2, start, nums,memo);
        int notPick = f(i - 1, start, nums,memo);

        return memo[i] = Math.max(pick, notPick);
    }
}