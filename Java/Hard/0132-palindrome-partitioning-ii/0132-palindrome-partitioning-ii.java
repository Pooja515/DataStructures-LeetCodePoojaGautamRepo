class Solution {
    int[] memo ;
    public int minCut(String s) {
        int n = s.length();
        memo  = new int[n];
        Arrays.fill(memo,-1);
        return f(0, n, s) - 1 ;
    }

    boolean isPallindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))  return false;
            i++;
            j--;
        }
        return true;
    }
    
    int f(int i, int n, String s) {
        if (i == n) return 0;
        if(memo[i] != -1) return memo[i];
        int mini = (int) 1e9;
        for (int j = i; j < n; j++) {
            if (isPallindrome(i, j, s)) {
                int cost = 1 + f(j + 1, n, s);
                mini = Math.min(mini, cost);
            }
        }

        return memo[i] =mini;
    }
}