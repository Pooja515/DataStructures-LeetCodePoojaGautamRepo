class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first =-1,last=-1;
        boolean flag = true;
        first = f(nums,target, true);
        if(first == -1) return new int[] {first,-1};
        last = f(nums,target,false);

        return new int[] {first,last};
    }

    int f(int[] nums,int target, boolean flag){
        int n=nums.length;
        int low =0 , high =n-1 ,ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(flag){
                if(nums[mid] == target){
                    ans=mid;
                    high =mid-1;

                }
                else if(nums[mid]>target) high=mid-1;
                else{
                    low =mid+1;
                }
            }
            else{
                 if(nums[mid] == target){
                    ans=mid;
                    low=mid+1;

                }
                  else if(nums[mid]<target) low=mid+1;
                else{
                    high=mid-1;
                }
            }
        }
        return ans;
    }
}