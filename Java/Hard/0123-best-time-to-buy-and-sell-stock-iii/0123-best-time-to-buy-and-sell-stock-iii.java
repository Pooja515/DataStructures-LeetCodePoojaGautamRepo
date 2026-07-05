class Solution {
    int[][][] memo;
    public int maxProfit(int[] prices) {

        int n = prices.length;
        memo = new int[n][2][3];
        for(int[][] mat : memo){
            for(int[] r: mat){
                  Arrays.fill(r , -1);
            }
        }
        return f(0,1,2,prices,n);
    }
    int f(int ind , int buy , int cap , int[] prices , int n){
        
        if(ind == n || cap == 0) return 0;

        int profit = 0;

        if(memo[ind][buy][cap] != -1) return memo[ind][buy][cap];

        if(buy == 1){

           int take = -prices[ind] + f(ind+1 , 0 , cap,prices ,n);
           int nottake = 0 + f(ind+1 , 1 ,cap , prices , n);
           profit = Math.max(take , nottake);
           memo[ind][buy][cap] = profit;

        }
        else{
             int take = prices[ind] + f(ind+1 , 1 , cap - 1,prices ,n);
             int nottake = 0 + f(ind+1 , 0 ,cap , prices , n);
             profit = Math.max(take , nottake);
             memo[ind][buy][cap] = profit;
        }
        return memo[ind][buy][cap];
    }
}