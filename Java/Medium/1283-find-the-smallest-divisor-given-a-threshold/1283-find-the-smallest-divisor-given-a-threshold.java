class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);//9
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, threshold)) {
            
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    boolean isPossible(int[] nums, int d,int threshold){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i]/d;
            if(nums[i] % d != 0){
                sum += 1;
            }
             if(sum > threshold) return false;//Early Termination This avoids unnecessary work once we already know the current divisor cannot be the answer.
        }
        return true;
    }
}
