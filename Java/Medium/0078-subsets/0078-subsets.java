class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();//outer list
        List<Integer> ans = new ArrayList<>();//inner list

        f(0, nums, ans, res);

        return res;
    }

    void f(int start, int[] nums, List<Integer> ans, List<List<Integer>> res) {
        res.add(new ArrayList<>(ans));
        for (int i = start; i < nums.length; i++) {
            //take
            ans.add(nums[i]);
            f(i + 1, nums, ans, res);
            //nottake i.e backtrack
            ans.remove(ans.size() - 1);
        }

    }
}