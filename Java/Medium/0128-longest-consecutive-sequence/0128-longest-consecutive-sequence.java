class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int maxlen = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            int cnt = 1;
            if (!set.contains(num - 1)) {
                int x = num;
                while (set.contains(x + 1)) {
                    cnt++;
                    x++;
                }
                maxlen = Math.max(maxlen, cnt);
            }
        }

        return maxlen;
    }
}