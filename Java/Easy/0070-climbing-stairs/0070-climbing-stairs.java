class Solution {
   public int climbStairs(int n) {
       if (n <= 2)
           return n;


       int[] memo = new int[n + 1];
       Arrays.fill(memo, -1);


       return climb(n, memo);
   }


   int climb(int i, int[] memo) {
       if (i <= 2)
           return i;


       if (memo[i] != -1)
           return memo[i];


       // Store the answer so each state is solved only once.
       return memo[i] = climb(i - 1, memo) + climb(i - 2, memo);
   }
}
