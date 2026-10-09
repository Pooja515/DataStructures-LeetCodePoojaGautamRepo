class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // Stores all subsets
        List<Integer> cur = new ArrayList<>(); // Mutable list, changes during backtracking
         
        Arrays.sort(nums);

        f(0, nums, cur, res);

        return res;
    }

    void f(int start, int[] nums, List<Integer> cur,
            List<List<Integer>> res) {

        // Save a COPY because cur will change during backtracking
        res.add(new ArrayList<>(cur));

        // No explicit base case needed. The loop stops when start == nums.length
        for (int i = start; i < nums.length; i++) {
            
            if(i>start && nums[i] == nums[i-1]) continue;

            cur.add(nums[i]); // Choose an element
            f(i + 1, nums, cur, res); // Explore remaining elements
            cur.remove(cur.size() - 1); // Undo the choice (backtrack)
        }
    }

}
