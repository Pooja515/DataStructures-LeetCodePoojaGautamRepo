class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[m+1][m+1];

        for(int ind1 =0;ind1 <=m;ind1++){
            for(int ind2 =0;ind2 <=m;ind2++){
                  if(ind1 == 0 || ind2 == 0) {
                    dp[ind1][ind2] = 0;
                  }
                  else{
                    if(s.charAt(ind1-1) == s2.charAt(ind2-1)){
                        dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    }
                    else{
                         dp[ind1][ind2] =  Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                    }
                  }
            }
        }
      return dp[m][m];
    }
}