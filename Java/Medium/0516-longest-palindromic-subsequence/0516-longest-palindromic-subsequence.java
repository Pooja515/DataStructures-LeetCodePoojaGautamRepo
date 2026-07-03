class Solution {
  
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        String s2 =  new StringBuilder(s).reverse().toString();

        
        int m = s2.length();

        int[] dp = new int[m+1];

        for(int i = 0;i<=n;i++){
              int[] cur = new int[m+1];
            for(int j=0;j<=m;j++){

                 if(i == 0 || j == 0){
                    cur[j] =0;
                 }

                 else{
                       if(s.charAt(i-1) == s2.charAt(j-1)){
                              cur[j] = 1 + dp[j-1];
                        }
                        else{
                             cur[j] = 0 + Math.max(dp[j] , cur[j-1] );
                          } 
                    }
                    
                }
                dp = cur;
            }
      return dp[m];
    }
    /** 
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
    */
}