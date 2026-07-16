class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length() , n = t.length();
        if(n != m) return false;

        int[] freq = new int[26];

        for(int i=0;i<m;i++){
            char c = s.charAt(i);
            freq[c-'a']++;
        }
         for(int i=0;i<m;i++){
            char c = t.charAt(i);
            freq[c-'a']--;
        }
        for(int it : freq){
            if(it > 0) return false;
        }
        return true;
    }
}