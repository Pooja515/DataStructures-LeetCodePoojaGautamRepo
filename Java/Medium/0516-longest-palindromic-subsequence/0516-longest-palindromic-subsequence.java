class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }
      
        String s1 = reverse(s , 0 , n-1);
        
        return f(n-1,n-1,s,s1);
    }
    int f(int i, int j , String s , String s1){
        if(i<0 || j<0) return 0;

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        // match 
        if(s.charAt(i) == s1.charAt(j))
               return memo[i][j] = 1+ f(i-1 , j-1 , s,s1);
    // not match 
    return memo[i][j] = 0 + Math.max(f(i-1 , j , s, s1) , f(i,j-1,s , s1));
    }

     String reverse (String s , int l, int r){
       char[] a = s.toCharArray();
            
        while (l<r){
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
        return new String(a);
    }
}