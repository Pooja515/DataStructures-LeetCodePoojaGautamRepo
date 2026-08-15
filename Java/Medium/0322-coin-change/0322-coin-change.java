class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        memo= new int[n][amount+1];

        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }

        if(amount == 0) return 0;
        if(n==1){
            if(amount % coins[0] == 0){
                return amount/coins[0];
            }
            else
                 return -1;
        }
        
        return f(0,amount ,coins) >= (int) 1e9 ?-1:f(0,amount ,coins);
    }
    int f(int ind ,int amount , int[] coins){

        //base case 
        if(amount == 0) return 0;

        if(ind == coins.length) return (int) 1e9;

        if(memo[ind][amount] != -1) return memo[ind][amount];

        //nottake
        int nottake = 0 + f(ind+1,amount,coins);
        int take = (int) 1e9;
        if(coins[ind] <= amount){
            take = 1 + f(ind,amount - coins[ind] , coins);
        }

        return memo[ind][amount] = Math.min(take,nottake);
    }
}