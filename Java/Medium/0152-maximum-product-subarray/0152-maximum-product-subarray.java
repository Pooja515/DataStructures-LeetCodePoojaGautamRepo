class Solution {
    public int maxProduct(int[] nums) {
        int suffix =1 , prefix =1, maxi=Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            maxi = Math.max(maxi, Math.max(prefix,suffix));
        }
        return maxi;
    }
}