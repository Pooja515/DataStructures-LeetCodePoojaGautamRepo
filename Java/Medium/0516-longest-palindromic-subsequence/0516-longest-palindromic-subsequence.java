class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();

        memo = new int[n][n];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }

        return f(n-1,n-1,s,t);

    }
    int f(int i , int j , String s , String t){
        if(i<0 || j<0) return 0;

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return  memo[i][j] = 1+ f(i-1,j-1,s,t);
        }
        return memo[i][j] = Math.max(f(i-1,j,s,t) , f(i,j-1,s,t));
    }
}