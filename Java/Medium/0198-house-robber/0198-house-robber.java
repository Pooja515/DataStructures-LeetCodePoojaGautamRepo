class Solution {
    int[] memo;
    public int rob(int[] nums) {
      int n = nums.length;
      memo = new int[n];
      Arrays.fill(memo,-1);

      if(n==1) return nums[0];
      if(n==2) return Math.max(nums[0] , nums[1]);

      return f(n-1,nums);   
    }

    int f(int i , int[] nums){
        if(i==0) return nums[0];
        if(i==1) return Math.max(nums[0],nums[1]);

        if(memo[i] != -1) return memo[i];

        int choice1 = nums[i] + f(i-2,nums);
        int choice2 = f(i-1,nums);

        return memo[i] =Math.max(choice1,choice2);
    }
}