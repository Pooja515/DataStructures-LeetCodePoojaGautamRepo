class Solution {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = new StringBuilder(s).reverse().toString();

        int[] dp=new int [n+1];
         for(int i=0;i<=n;i++){
              int[] cur=new int [n+1];
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    cur[j]=0;
                }
                else{
                    if(s.charAt(i-1) == s2.charAt(j-1)){
                            cur[j] = 1+dp[j-1];
                        }
                 else{
                        cur[j] = Math.max(dp[j],cur[j-1]);
                      }
                }
            }
            dp=cur;
         }
    return dp[n];
    }
}