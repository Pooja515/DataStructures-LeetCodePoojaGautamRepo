class Solution {
    public int climbStairs(int n) {
       if(n==0) return 0;

       int[] memo = new int[n+1];
       Arrays.fill(memo,-1);

       return f(n,memo); 
    }
    int f(int n,int[] memo){
        if(n <= 2) return n;

        if(memo[n] != -1) return memo[n];

        return memo[n] = f(n-1,memo) + f(n-2,memo);
    }
}