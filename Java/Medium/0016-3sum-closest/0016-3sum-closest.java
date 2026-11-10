class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closestsum = nums[0]+nums[1]+nums[2];
        int i=0;
        while(i<n){
            int j=i+1,k=n-1;
            while(j<k){
            int sum = nums[i]+nums[j]+nums[k];
            if(sum == target) return sum;
            if(Math.abs(sum-target)<Math.abs(closestsum-target)){
                closestsum=sum;
            }
            if(sum<target) j++;
            if(sum>target) k--;
        }
        i++;
        }
        return closestsum;

    }
}