class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String , List<String>> map = new HashMap<>();
      for(String str : strs){
        int n= str.length();
        int[] freq = new int[26];

        for(int i =0;i<n;i++){
            freq[str.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<26;i++){
            sb.append(freq[i]);
            sb.append("#");
        }
        String key = sb.toString();
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(str);

      }
     return new ArrayList<>(map.values());
    }
}