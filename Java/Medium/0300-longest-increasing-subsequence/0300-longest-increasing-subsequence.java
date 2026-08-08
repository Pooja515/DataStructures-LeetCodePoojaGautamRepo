class Solution {
    int[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n+1];
        for(int[] rows : memo){
            Arrays.fill(rows,-1);
        }

        return f(0,-1,nums);
    }
   
    
    int f(int ind ,int prev_ind ,int[] nums){

        if(ind == nums.length) return 0;

        if(memo[ind][prev_ind+1] != -1) 
                return memo[ind][prev_ind+1];

        // not take 
        int len= 0 + f(ind+1, prev_ind,nums);

        //take 
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
            int take = 1 + f(ind+1,ind,nums);
            len = Math.max(len , take);
        }

       return memo[ind][prev_ind+1] = len;
    }
}