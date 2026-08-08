class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length() , n= t.length();
        if(m <n) return 0;

        memo= new int[m][n];
        for(int[] rows:memo){
            Arrays.fill(rows,-1);
        }

        return f(m-1,n-1,s,t);

    }
    int f(int ind1,int ind2,String s1,String s2){
        if(ind2 <0) return 1;
        if(ind1 < 0) return 0;

        if(memo[ind1][ind2] != -1) return memo[ind1][ind2];

        //match 
        if(s1.charAt(ind1) == s2.charAt(ind2))
              return memo[ind1][ind2]= f(ind1-1,ind2-1,s1,s2) + f(ind1-1,ind2,s1,s2);
        
        return memo[ind1][ind2]=f(ind1-1,ind2,s1,s2);
    }
}