class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        int m=s.length(),n=t.length();
        memo=new int[m][n];
        for(int[] r:memo){
            Arrays.fill(r,-1);
        }

        return f(m-1,n-1,s,t);
    }
    int f(int i,int j,String s , String t){
        if(j<0) return 1;
        if(i<0) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return memo[i][j]=f(i-1,j-1,s,t)+f(i-1,j,s,t);
        }
        return memo[i][j]=f(i-1,j,s,t);
    }
}