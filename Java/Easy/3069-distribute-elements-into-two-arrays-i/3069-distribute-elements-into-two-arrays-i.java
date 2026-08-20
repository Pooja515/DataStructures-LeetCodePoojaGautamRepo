class Solution {
    public int[] resultArray(int[] nums) {

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        a1.add(nums[0]);
        a2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int last1 = a1.get(a1.size() - 1);
            int last2 = a2.get(a2.size() - 1);

            if (last1 >= last2) {
                a1.add(nums[i]);
            } else {
                a2.add(nums[i]);
            }

        }
        int[] res = new int[nums.length];
        int i = 0;
        for (int num : a1) {
            res[i++] = num;
        }
        for (int num : a2) {
            res[i++] = num;
        }
        return res;
    }
}