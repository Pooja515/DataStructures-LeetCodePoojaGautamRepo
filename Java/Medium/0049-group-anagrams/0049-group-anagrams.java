class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            int[] freq = new int[26];

            for(int i=0;i<str.length();i++){
                freq[str.charAt(i) -'a']++;
            }
          
            StringBuilder sb = new StringBuilder();
            for(int num : freq){
                sb.append(num);
                sb.append('#');
            }

            String key = sb.toString();

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
        
    }
}