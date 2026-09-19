class Solution {
    int[] memo;
    public int climbStairs(int n) {
        if(n <= 2) return n;
        memo= new int[n+1];

        Arrays.fill(memo,-1);

        return f(n);
    }
    int f(int i){
        if(i<=2) return i;

        if(memo[i] != -1) return memo[i];

        int climb1 = f(i-1);
        int climb2 = f(i-2);
        return memo[i] = climb1 + climb2;
    }
}