class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m= text1.length() , n= text2.length();
        int[][] memo = new int[m][n];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }
       // if(m ==0 || n==0) return 0;

        return f(m-1,n-1,text1,text2,memo);
    }

    int f(int i,int j,String s1 ,String s2,int[][] memo){
        if(i<0 || j<0) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return memo[i][j] = 1 +f(i-1,j-1,s1,s2,memo);
        }
        return  memo[i][j] = Math.max(f(i-1,j,s1,s2,memo) , f(i,j-1,s1,s2,memo));
    }
}