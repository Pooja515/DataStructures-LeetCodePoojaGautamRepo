class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int trap = 0, lmax = 0, rmax = 0, l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax) {
                trap += lmax - height[l];
                l++;
            } else {
                trap += rmax - height[r];
                r--;
            }
        }
        return trap;

    }
}