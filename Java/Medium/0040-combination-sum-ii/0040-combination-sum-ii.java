class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(candidates);

        f(0,target,candidates,cur,res);

        return res;
    }

    void f(int start,int target,int[] candidates, List<Integer> cur ,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=start;i<candidates.length;i++){

            if(i>start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            
            cur.add(candidates[i]);
            f(i+1,target-candidates[i],candidates,cur,res);
            cur.remove(cur.size()-1);
        }
    }
}