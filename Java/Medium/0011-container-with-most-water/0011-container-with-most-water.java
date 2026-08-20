class Solution {
    public int maxArea(int[] height) {
        int maxi = 0, l = 0, r = height.length - 1;

        while (l < r) {

            if (height[l] < height[r]) {
                int area = height[l] * (r - l);
                maxi = Math.max(maxi, area);
                l++;
            } else {
                int area = height[r] * (r - l);
                maxi = Math.max(maxi, area);
                r--;
            }

        }
        return maxi;
    }
}