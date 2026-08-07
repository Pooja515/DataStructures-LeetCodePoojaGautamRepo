class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        memo = new int[m][m];
        for(int[] rows : memo){
            Arrays.fill(rows,-1);
        }

        return f(m-1,m-1,s,s2);
        
    }
    int f(int ind1 , int ind2 , String s1 , String s2){

        if(ind1 < 0 || ind2 < 0) return 0;

        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];
        //matching 
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return memo[ind1][ind2] = 1+ f(ind1-1,ind2-1,s1,s2);
        }
        return memo[ind1][ind2] = Math.max(f(ind1-1,ind2,s1,s2),f(ind1,ind2-1,s1,s2));
    }
}