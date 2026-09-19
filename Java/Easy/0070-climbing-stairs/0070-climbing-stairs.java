class Solution {

    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
     
        int p2 = 1 , p1 = 1;

        for (int i = 2; i <= n; i++) {
      
            int cur = p2+p1;
            p2 = p1;
            p1 = cur;
        }
        return p1;
    }
}