class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m == 0 || n == 0)
            return 0;
        memo = new int[m][n];
        for(int[] rows: memo){
            Arrays.fill(rows,-1);
        }

        return f(m - 1, n - 1, text1, text2);
    }

    int f(int ind1,int ind2 , String s1 , String s2){
      if(ind1<0 || ind2<0){
        return 0;
      }

      if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        // choices
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return memo[ind1][ind2] = 1 + f(ind1-1 , ind2 - 1 ,s1,s2);
        }

        return memo[ind1][ind2] = Math.max(f(ind1-1,ind2,s1,s2) , f(ind1,ind2-1,s1,s2));
    }
}