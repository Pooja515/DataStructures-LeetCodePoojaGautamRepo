class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        f(0,nums,res,cur);

        return res;
    
    }
    
    void f(int start,int[] nums,List<List<Integer>> res , List<Integer> cur){
        res.add(new ArrayList<>(cur));

        for(int i= start ;i<nums.length;i++){
            cur.add(nums[i]);
            f(i+1,nums,res,cur);
            cur.remove(cur.size()-1);
        }
    }
}