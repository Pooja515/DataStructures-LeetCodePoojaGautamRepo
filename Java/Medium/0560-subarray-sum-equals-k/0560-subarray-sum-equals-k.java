class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int rightsum =0 , cnt=0;

        for(int i=0;i<nums.length;i++){
            rightsum += nums[i];
            if(map.containsKey(rightsum - k)){
                cnt += map.get(rightsum - k);
            }

            map.put(rightsum,map.getOrDefault(rightsum,0)+1);
        }
        return cnt;
    }
}