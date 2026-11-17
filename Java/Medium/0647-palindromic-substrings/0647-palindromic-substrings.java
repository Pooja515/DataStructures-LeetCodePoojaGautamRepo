class Solution {
    int cnt=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            expand(i,i,s);
            expand(i,i+1,s);
        }
        return cnt;

    }
    void expand(int l,int r,String s){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            cnt++;
            l--;
            r++;
        }
    }
}