class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(m<n) return false;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s1.charAt(i);
            freq[c - 'a']++;
        }
        int cnt = n , l=0;
        for(int r =0 ; r<m;r++){
            char c = s2.charAt(r);
            if(freq[c-'a']>0) cnt--;
            freq[c - 'a']--;
            if(cnt == 0) return true;

            if(r-l+1 == n){
                 char left = s2.charAt(l);
                 if( freq[left - 'a'] >=0) cnt++;
                 freq[left - 'a']++;
                 l++;
            }
        }
        return false;
    }
}
        
          