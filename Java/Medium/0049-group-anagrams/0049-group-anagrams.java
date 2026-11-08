class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { 
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            int[] freq=new int[26];
            for(int i=0;i<s.length();i++){
                freq[s.charAt(i)-'a']++;
            }

            StringBuilder str = new StringBuilder();
            for(int n:freq){
                str.append(n);
                str.append('#');
            }

            String key = str.toString();
/** 
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            map.put(key,new ArrayList<>());
            */
             map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }  

        return new ArrayList<>(map.values());
    }
}