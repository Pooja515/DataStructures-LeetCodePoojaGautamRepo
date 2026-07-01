class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxlen = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int cnt = 1;
                int x = num;
                while(set.contains(x+1)){
                     x=x+1;
                     cnt++;
                }
                maxlen = Math.max(maxlen , cnt);
            }
        }
        return maxlen;
    }
}