class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        return n - longestPalindromeSubseq(s); 
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i = 0;i<=n;i++){
            for(int j=0;j<=n;j++){

                 if(i == 0 || j == 0){
                    dp[i][j] =0;
                 }

                 else{
                      if (s.charAt(i - 1) == s.charAt(n - j)) {
                              dp[i][j] = 1 + dp[i-1][j-1];
                        }
                        else{
                             dp[i][j] = 0 + Math.max(dp[i-1][j] , dp[i][j-1] );
                          } 
                    }
                    
                }
            }
      return dp[n][n];
    }
}