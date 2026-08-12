class Solution {
    public int[] productExceptSelf(int[] nums) {
       int pre = 1 , suff =1;
       int n = nums.length;
       int[] ans = new int[n];
       for(int i=0;i<n;i++){
           ans[i] = pre;
           pre *= nums[i];
       } 
       for(int i=n-1 ;i>=0;i--){
        ans[i] *= suff;
        suff *= nums[i];
       }
       return ans;
    }
}