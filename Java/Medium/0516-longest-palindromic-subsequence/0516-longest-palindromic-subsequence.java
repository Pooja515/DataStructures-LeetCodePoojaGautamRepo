class Solution {
  
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        String s2 = reverse(s, 0 , n-1);
        
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0;i<=n;i++){
            for(int j=0;j<=m;j++){

                 if(i == 0 || j == 0){
                    dp[i][j] =0;
                 }

                 else{
                       if(s.charAt(i-1) == s2.charAt(j-1)){
                              dp[i][j] = 1 + dp[i-1][j-1];
                        }
                        else{
                             dp[i][j] = 0 + Math.max(dp[i-1][j] , dp[i][j-1] );
                          } 
                    }
                    
                }
            }
      return dp[n][m];
    }
    String reverse(String s , int l , int r){
        char[] a = s.toCharArray();
        while(l<r){
        char temp = a[l];
        a[l] = a[r];
        a[r] = temp;
        l++;
        r--;
       }
       return new String(a);
    }
}