class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
       int m= text1.length() , n=text2.length();

       memo = new int[m][n];
       for(int[] r:memo){
          Arrays.fill(r,-1);
       }

       return f(m-1,n-1,text1,text2); 
    }

    int f(int i , int j , String s1 , String s2){
        if(i<0 || j<0) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] = 1 + f(i-1,j-1,s1,s2);
        }

        return memo[i][j] = Math.max(f(i-1,j,s1,s2) , f(i,j-1,s1,s2));
    }
}