class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int m = s.length(), n = t.length();
        if (n < m || n>m)
            return false;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        int cnt = m;
        for(int i=0;i<n;i++){
            char c= t.charAt(i);
            freq[c-'a']--;
            if(freq[c-'a'] >= 0) cnt--;
            if(cnt==0) return true;
        }
        return false;
    }
}