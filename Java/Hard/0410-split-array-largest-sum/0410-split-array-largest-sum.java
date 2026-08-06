class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
      
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isvalid(nums,mid,k)){
            
               high=mid-1;
            }
            else
                    low=mid+1;
        }
        return low;
    }
    boolean isvalid(int[] nums,int mid,int k){
          int cnt=1,sum=0;
          for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                sum=nums[i];
                cnt++;
            }
          }
          if(cnt<=k)
               return true;
     return false;
    }
}