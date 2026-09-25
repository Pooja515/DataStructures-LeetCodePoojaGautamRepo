class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        int n= coins.length;

        memo = new int[n][amount+1];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }

        return f(n-1,amount,coins);
    }

    int f(int i,int target,int[] coins){
        if(target == 0) return 1;
        if(i<0) return 0;

        if(memo[i][target] != -1) return memo[i][target];

        int nottake = f(i-1,target,coins);
        int take = 0;
        if(coins[i] <= target){
            take = f(i,target-coins[i],coins);
        }

        return memo[i][target] = take + nottake;
    }
}