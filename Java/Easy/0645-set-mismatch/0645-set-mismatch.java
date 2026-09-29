class Solution {
    public int[] findErrorNums(int[] nums) {
       int n=nums.length;
       int repeating =-1 ,missing=-1;
       int[] ans = new int[n+1];

       for(int num:nums){
        ans[num]++;
       }

       for(int i=1;i<=n;i++){
            if(ans[i]==2) repeating =i;
            else if (ans[i]==0) missing =i;
        } 

       

       return new int[] {repeating,missing};
    }
}