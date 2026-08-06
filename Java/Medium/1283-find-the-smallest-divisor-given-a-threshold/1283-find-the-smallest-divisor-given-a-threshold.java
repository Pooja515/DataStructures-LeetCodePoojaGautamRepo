class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0, ans = 0;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);//9
        }
        ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean isValid(int[] nums, int d,int threshold){
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i]/d;
            if(nums[i] % d != 0){
                sum += 1;
            }
        }
        return sum <= threshold;
    }
}
/** 
    Binary search
    based on answers:
    monotonic incr
    or monotonic decr

    ==>
    Find the
    smallest divisor
    such that
    the result<=threshold==>
    take ceil value=7/3=3,10/2=5

    1)
    As divisor incr,
    the sum
    decr so, we
    need to
    find sum<=
    threshold

Find
    what shows
    monotonic behavior
    that is divisor,
    As the
    divisor increases
    the sum decreases.So,
    minimum divisor
    and maximum
    divisor choose and do
    binary search
    on that
    range to
    find the
    smalllest divisor
    less than
    or equal
    to threshold

    nums=[1,2,5,9]mini=Integer.MAX_VALUE;maxi=Integer.MIN_VALUE;for(
    int i = 0;i<nums.length;i++)
    {
        mini = Math.min(mini, nums[i]);//1
        maxi = Math.max(maxi, nums[i]);//9

}
This gives
us divisor
range from 1 to 9:
minm divisor:1
maximum divisor is:9

basically positive
integer divisor
divide all
the arrray
by it, and
the sum
the division
results
*/