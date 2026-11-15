class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
       memo = new int[n][amount+1];
       for(int[] rows: memo){
           Arrays.fill(rows,-1);
       }

       return f(n-1,amount,coins) >= (int) 1e9 ? -1:f(n-1,amount,coins);
    }
    int f(int i , int amount ,int[] coins){
        if(i==0){
            if(amount % coins[i] == 0){
                return amount/coins[i];
            }
            else{
                return (int) 1e9;
            }
        }

        if(memo[i][amount] != -1){
            return memo[i][amount];
        }

        int nottake = f(i-1,amount ,coins);
        int take = (int) 1e9;
        if(coins[i] <= amount){
            take = 1 + f(i,amount - coins[i],coins);
        }

        return memo[i][amount] = Math.min(take,nottake);
    }
}