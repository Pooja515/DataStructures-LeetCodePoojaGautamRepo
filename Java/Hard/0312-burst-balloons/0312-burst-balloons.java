class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] arr = new int[m + 2];
        arr[0] = 1;
        arr[m + 1] = 1;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = nums[i];
        }
         memo = new int[m + 2][m + 2];
         for (int[] row : memo) {
            Arrays.fill(row, -1);
        }


        return f(1, m, arr);
    }

    int f(int i ,int j ,int[] nums){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        for(int ind =i;ind <= j ;ind++){
            int cost = nums[i-1] * nums[ind] * nums[j+1] + f(i,ind-1,nums) + f(ind+1,j,nums);
            maxi = Math.max(maxi, cost);

        }
        return memo[i][j] = maxi;
    }
}