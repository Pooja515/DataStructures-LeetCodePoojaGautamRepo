class Solution {
    public int[] findErrorNums(int[] nums) {
       int n=nums.length;
       int repeating =-1 ,missing=-1;

       for(int i=1;i<=n;i++){
          int cnt=0;
          for(int j=0;j<n;j++){
              if(nums[j] == i){
                cnt++;
              }
            }
            if(cnt==2) repeating =i;
            if(cnt==0) missing =i;
        } 

       

       return new int[] {repeating,missing};
    }
}