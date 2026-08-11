class Solution {
    int[] memo ;
    public int rob(int[] nums) {
       int n = nums.length;
       memo = new int[n];
       Arrays.fill(memo,-1);
       return f(n-1,nums); 
    }
    int f(int i , int[] nums){
        //base case
        if(i == 0 ) return nums[i];
        if(i==1) return Math.max(nums[0],nums[1]);

        if(memo[i] != -1) return memo[i];

        // notake 
        int nottake = 0 + f(i-1,nums);
        int take = 0;
        if(i>1){
            take = nums[i] + f(i-2,nums);
        }
        return memo[i] = Math.max(take,nottake);
    }
}