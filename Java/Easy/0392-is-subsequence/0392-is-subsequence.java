class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length() , n=t.length();
        if(m==0) return true;
        int l=0;

        for(int r=0 ;r<n;r++){
            if(s.charAt(l) == t.charAt(r)){
                
                l++;
               
            }
           if(l == m) return true;
       
        }
        return false;
    }
}