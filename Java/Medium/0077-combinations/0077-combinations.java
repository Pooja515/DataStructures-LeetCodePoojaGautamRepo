class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        f(1,n,k,res,cur);

        return res;
        
    }

    void f(int start,int n,int k , List<List<Integer>>res, List<Integer> cur){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=start;i<=n;i++){
            cur.add(i);
            f(i+1,n,k,res,cur);
            cur.remove(cur.size()-1);
        }

    }
}