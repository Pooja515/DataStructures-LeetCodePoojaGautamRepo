class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0 , r=n-1 , maxarea = 0;
        while(l<r){
            int length= Math.min(height[l],height[r]);
            int breadth = r-l;
            int area = length * breadth;

            maxarea=Math.max(maxarea,area);

            if(height[l]<height[r]) l++;
            else{
                r--;
            }
        }
        return maxarea;
    }
}