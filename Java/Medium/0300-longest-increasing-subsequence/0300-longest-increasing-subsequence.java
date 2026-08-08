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
    
        int nottake= 0 + f(ind+1, prev_ind,nums);

        //take 
        int take=0;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]){
            take = 1 + f(ind+1,ind,nums);
            
        }

       return memo[ind][prev_ind+1] = Math.max(take,nottake);
    }
}