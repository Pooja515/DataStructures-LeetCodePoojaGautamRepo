class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        int maxlen = 0;

        for (int num : set) {
    
            if (!set.contains(num - 1)) {
                int x = num;
                int cnt = 1;
                while (set.contains(x+1)) {
                    cnt++;
                    x++;
                }
            maxlen = Math.max(maxlen, cnt);

            }
        }
        return maxlen;
    }
}


