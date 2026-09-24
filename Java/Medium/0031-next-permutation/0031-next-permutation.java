class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int point = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] <nums[i+1]){
                point =i;
                break;
            }
        }
        if(point == -1){
            reverse(0,n-1,nums);
            return;
        }

        for(int i=n-1;i>point;i--){
            if(nums[i] > nums[point]){
               int temp=nums[i];
                nums[i]=nums[point];
                nums[point]=temp;
                break;
            }
        }

        reverse(point+1,n-1,nums);
        }
      void reverse(int l,int r,int[] nums){
            while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
        
    }
}