class Solution {
    public void rotate(int[] nums, int k) {
       int n= nums.length;
       k=k%n;
       rotate(0,n-1,nums,k);
       rotate(0,k-1,nums,k);
       rotate(k,n-1,nums,k); 
    }
    void rotate(int i ,int j ,int[] nums,int k){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}