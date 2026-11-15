class Solution {
    int[] memo1;
    int[] memo2;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int[] excludelast = new int[n-1];
       
        int[] excludefirst = new int[n-1];

        for(int i=0;i<n-1;i++){
            excludelast[i] = nums[i];
        }

        for(int i=1;i<n;i++){
            excludefirst[i-1] = nums[i];
        }

        int m =  excludelast.length;
        memo1 = new int[m];
        memo2 = new int[m];

        Arrays.fill(memo1,-1);
        Arrays.fill(memo2,-1);

        int last = f(m-1,excludelast,memo1);
        int first = f(m-1,excludefirst,memo2);

        return Math.max(last,first);
    }

    int f(int i ,int[] nums,int[] memo){
      
        if(i==0) return nums[0];
        if(i==1) return Math.max(nums[0],nums[1]);

        if(memo[i] != -1) return memo[i];

        int choice1 = nums[i] + f(i-2,nums,memo);
        int choice2 = f(i-1,nums,memo);
       
       return memo[i] = Math.max(choice1,choice2);
    }
}