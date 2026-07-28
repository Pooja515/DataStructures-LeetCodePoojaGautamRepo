class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        int rightsum = 0 ,count = 0;

        // rightsum - leftsum = k

        for (int num : nums) {

            rightsum += num;

            int leftsum = rightsum - k;

            count += map.getOrDefault(leftsum, 0);

            map.put(rightsum,map.getOrDefault(rightsum, 0) + 1);
        }
      return count;
    }
}