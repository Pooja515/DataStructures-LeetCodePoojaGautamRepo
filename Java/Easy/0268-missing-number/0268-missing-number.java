class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n;
        for(int i=0;i<n;i++){
            xor ^= nums[i] ^ i;
        }
        return xor;
    }
}