class Solution {
    public int characterReplacement(String s, int k) {
       int n = s.length();
       int[] freq = new int[26];
       int maxlen =0 , maxfreq =0;
       int l=0;
       for(int r= 0;r<n;r++ ){
          char c = s.charAt(r);
          freq[c-'A']++;
          maxfreq = Math.max(maxfreq, freq[c-'A']);
          while(r-l+1 - maxfreq > k){
              char left = s.charAt(l);
              freq[left-'A']--;
              l++;
          }
          maxlen = Math.max(maxlen , r-l+1);
       } 
       return maxlen;
    }
}