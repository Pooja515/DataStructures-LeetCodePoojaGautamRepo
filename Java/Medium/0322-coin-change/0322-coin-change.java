class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        memo = new int[n][amount + 1];
        for(int[] rows : memo){
            Arrays.fill(rows , -1);
        }
        int res = f(n - 1, amount, coins);
        return res >= (int) 1e9 ? -1 : res;
    }

    int f(int ind, int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }

        if (ind == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else
                return (int) 1e9;
        }
        if(memo[ind][amount] != -1) return memo[ind][amount];
        int notpick = 0 + f(ind - 1, amount, coins);
        int pick = (int) 1e9;
        if (coins[ind] <= amount) {
            pick = 1 + f(ind, amount - coins[ind], coins);
        }

        return memo[ind][amount] =  Math.min(pick, notpick);
    }
}