class Solution {
    public int[] searchRange(int[] nums, int target) {
        boolean isfirst = true;
        int n = nums.length;
        int low = 0, high = n - 1;
        int first = f(0, n - 1, nums, target, true);
        if (first == -1)
            return new int[] { -1, -1 };
        int second = f(0, n - 1, nums, target, false);
        return new int[] { first, second };
    }

    int f(int low, int high, int[] nums, int target, boolean istrue) {
        int ans = -1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (istrue) {
                if (nums[mid] == target) {
                    ans = mid;
                    high = mid - 1;
                } else if(nums[mid] < target) low=mid+1;
                  else
                        high=mid-1;
            } else {
                if (nums[mid] == target) {
                    ans = mid;
                    low = mid + 1;
                } 
                else if(nums[mid] < target) low = mid+1;
                else
                        high = mid - 1;

            }
        }
        return ans;
    }
}