class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length() , n=s2.length();
        if(m>n) return false;

        int[] freq = new int[26];

        for(int i=0;i<m;i++){
            char c = s1.charAt(i);
            freq[c-'a']++;
        }

        int l=0, cnt = m;

        for(int r=0;r<n;r++){
            char c = s2.charAt(r);
            if(freq[c-'a'] > 0) cnt--;
            freq[c-'a']--;

            if(cnt == 0) return true;

            if(r-l+1 == m){
               char left = s2.charAt(l);
               if(freq[left-'a'] >= 0) cnt++;
               freq[left-'a']++;
               l++;
            }

        }
        return false;
    }
}