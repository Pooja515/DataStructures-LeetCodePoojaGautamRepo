class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0, maxi = 0,n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0)
                cnt++;
            else
                cnt = 0;
            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
}