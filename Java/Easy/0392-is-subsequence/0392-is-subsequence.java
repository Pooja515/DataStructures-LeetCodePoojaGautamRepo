class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length() , n=t.length();
        if(m==0) return true;
        int l=0 ,cnt = m;

        for(int r=0 ;r<n;r++){
            if(s.charAt(l) == t.charAt(r)){
                cnt--;
                l++;
               
            }
           if(cnt == 0) return true;
       
        }
        return false;
    }
}