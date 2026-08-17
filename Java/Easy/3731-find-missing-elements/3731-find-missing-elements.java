class Solution {
    public List<Integer> findMissingElements(int[] nums) {
         List<Integer> ans = new ArrayList<>();
         Set<Integer> set = new HashSet<>();

         int mini=Integer.MAX_VALUE;
         int maxi = Integer.MIN_VALUE;

         for(int num : nums){  
            mini = Math.min(mini ,num);
            maxi= Math.max(maxi,num);
            set.add(num);
         }

         for(int i = mini ;i <= maxi; i++){
            if(!set.contains(i)) ans.add(i);
         }

         return ans;
    }
}