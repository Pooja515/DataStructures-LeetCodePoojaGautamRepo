class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String s2 = reverse(s, 0 , n-1);
        int m = s2.length();
        memo = new int[n][m];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }

        return f(n-1 , m-1 , s , s2);

    }
    int f(int i , int j , String s1 , String s2){
        if(i< 0 || j<0) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return  memo[i][j] = 1 + f(i-1 , j-1 , s1 ,s2);
        }
        return memo[i][j] = 0 + Math.max(f(i-1 , j , s1 , s2) , f(i,j-1 , s1 , s2));
    }
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
}