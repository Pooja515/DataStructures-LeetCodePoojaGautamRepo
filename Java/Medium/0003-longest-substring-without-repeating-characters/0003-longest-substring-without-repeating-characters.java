class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character , Integer> map = new HashMap<>();
       int l =0 , maxlen = 0;
       for(int r=0 ; r < s.length(); r++){
           if(map.containsKey(s.charAt(r))){
             l = Math.max(l , map.get(s.charAt(r))+1);
           }
           map.put(s.charAt(r) , r);
           maxlen = Math.max(maxlen ,r-l+1);
       } 
       return maxlen;
    }
}