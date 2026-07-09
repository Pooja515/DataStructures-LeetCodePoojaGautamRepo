class Solution {
    int[] memo;
    public int climbStairs(int n) {
        if(n <= 1) return 1;
        if(n==2) return n;
        memo = new int[n+1] ;
        Arrays.fill(memo , -1);
        return f(n);
    }
    int f(int n){
        if(n <=1) return 1;
         if(n==2) return n;
        if(memo[n] != -1) return memo[n];

        return memo[n] = f(n-1) +f(n-2);
    }
}