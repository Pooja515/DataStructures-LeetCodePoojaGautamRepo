class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] memo = new int[n+1];
        Arrays.fill(memo , -1);
        
        return f(n,memo);
    }
    int f(int n , int[] memo){
        if(n <= 1) return n;

        if(memo[n] != -1) return memo[n];

        return f(n-1 , memo) + f(n-2,memo);
    }
}