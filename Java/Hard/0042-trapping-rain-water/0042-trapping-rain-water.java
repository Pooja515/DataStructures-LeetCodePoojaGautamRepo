class Solution {
    public int trap(int[] height) {
       int trap = 0 , n= height.length, lmax=0,rmax=0,l=0,r=n-1;
       while (l<=r){
        lmax = Math.max(lmax,height[l]);
        rmax = Math.max(rmax,height[r]);
        if(lmax <= rmax){
            trap += lmax-height[l];
            l++;
        }
        else{
            trap += rmax-height[r];
            r--;
        }
       } 
       return trap;
    }
}