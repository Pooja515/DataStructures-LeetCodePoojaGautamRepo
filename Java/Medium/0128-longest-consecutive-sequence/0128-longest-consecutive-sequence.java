class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
           set.add(num);
        }
        int maxi=0;
        for(int num : set){
            if(!set.contains(num-1)){
                int cnt = 1;
                int x = num;
                while(set.contains(x+1)){
                    cnt++;
                    x++;
                }
                maxi= Math.max(maxi,cnt);
            }
        }
        return maxi;
    }
}