class Solution {
    int start =0, maxlen =0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            expand(i,i,s);
            expand(i,i+1,s);
        }

        return s.substring(start,start + maxlen);
    }
    void expand(int l,int r,String s){
        while(l>= 0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        if(r-l-1 > maxlen){
            maxlen = r-l-1;
            start = l+1;
        }
    }
}