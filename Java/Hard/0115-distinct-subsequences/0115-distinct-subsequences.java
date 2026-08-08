class Solution {

    public int numDistinct(String s, String t) {
        int m = s.length() , n= t.length();
        if(m <n) return 0;

        int[][] dp= new int[m+1][n+1];

        for(int ind1 =0 ;ind1 <= m;ind1++){
            dp[ind1][0] = 1;
        }

        for(int ind1=1;ind1 <= m; ind1++){
            for(int ind2 = 1 ; ind2 <= n ; ind2++){

               if(s.charAt(ind1-1) == t.charAt(ind2-1)){
                    dp[ind1][ind2]= dp[ind1-1][ind2-1] + dp[ind1-1][ind2];
               }
                else{
                      dp[ind1][ind2]=dp[ind1-1][ind2];
               }
            }
        }
    return dp[m][n];
    }
}