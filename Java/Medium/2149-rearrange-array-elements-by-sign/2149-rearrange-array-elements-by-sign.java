class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] a1=new int[n/2];
        int[] a2=new int[n/2];

        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(nums[i] >=0){
                a1[j++] = nums[i];
            }
            else{
                a2[k++] = nums[i];
            }
        }
        int[] res=new int[n];
        int l=0 ,r=0 , m=0;
        while(l<n/2 && r<n/2){
            res[m++] = a1[l++];
            res[m++] = a2[r++];
        }
        return res;
    }
}