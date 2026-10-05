class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1, high = 1;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isvalid(mid, nums, threshold)) {
                ans = mid;
                high = mid - 1;
               
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isvalid(int mid, int[] nums, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += num / mid;
            if (num % mid != 0) {
                sum += 1;
            }
            if(sum > threshold) return false;
        }
        return true;
    }
}
