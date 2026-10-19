class Solution {
    public int fib(int n) {
     
      int [] memo = new int[n+1];
      Arrays.fill(memo,-1);

      return f(n,memo);  
    }
    int f(int i,int[] memo){
        if(i<=1) return i;

        if(memo[i] != -1) return memo[i];

        return memo[i] = f(i-1,memo)+f(i-2,memo);
    }
}