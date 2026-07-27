class Solution {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();
        if(m<n) return "";
        int[] freq=new int[128];
        for(char c:t.toCharArray()){
            freq[c]++;
        }
        int l=0,cnt=n,minlen=Integer.MAX_VALUE,start=0;
        for(int r=0;r<m;r++){
            char c=s.charAt(r);
            if(freq[c]>0){
                cnt--;
            }
             freq[c]--;
             while(cnt==0){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    start=l;
                }
                char left=s.charAt(l);
                freq[left]++;

                if(freq[left]>0)
                       cnt++;
                l++;
             }   
            
        }
        return minlen==Integer.MAX_VALUE?"":s.substring(start,start+minlen);
    }
}