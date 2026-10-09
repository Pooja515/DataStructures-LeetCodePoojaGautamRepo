class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         List<Integer> curr = new ArrayList<>();

         f(0,nums,res,curr);

         return res;
        
    }

    void f(int start,int[] nums, List<List<Integer>> res, List<Integer> curr){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            f(i+1,nums,res,curr);
            curr.remove(curr.size()-1);
        }
    }
}