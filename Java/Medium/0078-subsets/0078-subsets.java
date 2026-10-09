class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        f(0,nums,cur,res);

        return res;
        
    }

    void f(int start , int[] nums ,  List<Integer> cur ,List<List<Integer>> res ){
       
        res.add(new ArrayList<>(cur));
           
        for(int i=start;i<nums.length;i++){

        cur.add(nums[i]); // take
        f(i+1,nums,cur,res);
        cur.remove(cur.size()-1); // backtracking i.e nottake
       
        }

    }
}