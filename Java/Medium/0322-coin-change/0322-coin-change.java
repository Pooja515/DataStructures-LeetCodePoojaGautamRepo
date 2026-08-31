class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        memo=new int[n][amount+1];
        for(int[] rows: memo){
            Arrays.fill(rows,-1);
        }

        int res = f(n - 1, amount, coins);

        return res >= (int) 1e9 ? -1 : res;
    }

    int f(int i, int target, int[] coins) {

        if (target == 0)
            return 0;
        if (i == 0) {

            if (target % coins[0] == 0) {
                return target / coins[0];
            }

            else
                return (int) 1e9;

        }

        if(memo[i][target] != -1) return memo[i][target];

        int nottake = f(i - 1, target, coins);
        int take = (int) 1e9;
        if (coins[i] <= target) {
            take = 1 + f(i, target - coins[i], coins);
        }

        return memo[i][target] = Math.min(take, nottake);
    }
}