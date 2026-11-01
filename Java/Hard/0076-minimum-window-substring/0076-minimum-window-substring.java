class Solution {
    public String minWindow(String s, String t) {
        int m = s.length() , n = t.length();
        if(m<n || s== null || t== null) return "";

        int[] freq = new int[128];

        for(int i=0;i<n;i++){
            char c = t.charAt(i);
            freq[c]++;
        }

        int cnt = n ,l=0 ,minlen=Integer.MAX_VALUE , start=0;

        for(int r=0;r<m;r++){
            char c = s.charAt(r);
            if(freq[c]>0){
                cnt--;
            }
            freq[c]--;

            while(cnt == 0){
                if(r-l+1 <minlen){
                    minlen = r-l+1;
                    start=l;
                }
            
                char left = s.charAt(l);
                if(freq[left]>=0) cnt++;
                freq[left]++;
                l++;
            }
            

        }
       
       return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}