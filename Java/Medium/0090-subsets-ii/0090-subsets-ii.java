class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         List<Integer> cur = new ArrayList<>();
         Arrays.sort(nums);

         f(0,nums,cur,res);

         return res;

    }
    void f(int start , int[] nums,List<Integer> cur ,List<List<Integer>> res){
        res.add(new ArrayList<>(cur));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            f(i+1,nums,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}