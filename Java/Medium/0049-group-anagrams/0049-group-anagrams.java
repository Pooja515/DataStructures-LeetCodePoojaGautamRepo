class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] a = str.toCharArray();

            Arrays.sort(a);

            String key = String.valueOf(a);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}