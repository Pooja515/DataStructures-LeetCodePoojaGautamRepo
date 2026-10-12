class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cnt=0,maxi=0;
        for(int r=0;r<n;r++){
            if(nums[r] == 0) cnt=0;
            else{
                cnt++;
            }
            maxi=Math.max(maxi,cnt);
        }
        return maxi;
    }
}