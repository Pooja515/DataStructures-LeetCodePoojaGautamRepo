class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
       int[] ans = new int[n];
       int pre=1,suf=1;
       for(int i=0;i<n;i++){
        ans[i] = pre;
        pre *= nums[i];
       } 
       for(int r=n-1;r>=0;r--){
         ans[r] *= suf;
         suf *= nums[r];
       }
       return ans;
    }
}