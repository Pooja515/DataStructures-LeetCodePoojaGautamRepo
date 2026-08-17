class Solution {
    public List<Integer> findMissingElements(int[] nums) {
         List<Integer> ans = new ArrayList<>();
         Set<Integer> set = new HashSet<>();

         int mini=Integer.MAX_VALUE;
         int maxi = Integer.MIN_VALUE;

         for(int num : nums){  //O(N)
            mini = Math.min(mini ,num);
            maxi= Math.max(maxi,num);
            set.add(num);
         }

         for(int i = mini ;i <= maxi; i++){ // O(K)
            if(!set.contains(i)) ans.add(i);
         }

         return ans;
    }
}
//Time complexity : O(N * K)// The second loop runs K times (from mini to maxi).
// Space Complexity :O(N)