class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        int n = coins.length;

        memo = new int[n][amount + 1];
        for(int[] rows : memo){
            Arrays.fill(rows,-1);
        }

        return f(n-1,amount,coins);
    }
    int f(int i , int amount , int[] coins){

        if(amount == 0) return 1;
        if(i==0){
            if(amount % coins[0] == 0) return 1;
            else
                  return 0;
        }


        if(memo[i][amount] != -1) return memo[i][amount];
        // choices
        int nottake = f(i-1,amount,coins);
        int take = 0;
        if(coins[i] <= amount){
            take = f(i,amount-coins[i],coins);
        }

        return memo[i][amount] = take + nottake;
    }
}