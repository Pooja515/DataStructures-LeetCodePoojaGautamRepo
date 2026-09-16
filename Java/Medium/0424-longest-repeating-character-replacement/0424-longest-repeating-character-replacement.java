class Solution {
    public int characterReplacement(String s, int k) {
       int l=0 ,maxfreq =0,cnt =0,maxi=0;
       HashMap<Character,Integer> map = new HashMap<>();
       for(int r=0;r<s.length();r++){
         map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
          maxfreq=Math.max(map.get(s.charAt(r)),maxfreq);
          while((r-l+1) -maxfreq > k){
            map.put(s.charAt(l),map.get(s.charAt(l))-1);
            if(map.get(s.charAt(l))== 0) map.remove(s.charAt(l));
            l++;
          }
        maxi=Math.max(maxi,r-l+1);
       } 
       return maxi;
    }
}