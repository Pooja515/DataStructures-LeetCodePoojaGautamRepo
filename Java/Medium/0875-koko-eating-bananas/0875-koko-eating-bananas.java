class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high = 1,ans=1;
        for(int num:piles){
            high = Math.max(high,num);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isvalid(mid,piles,h)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }

    boolean isvalid(int mid,int[] piles,int h){
        int sum =0;
        for(int num:piles){
            sum+= num/mid;
            if(num%mid !=0) sum+=1;
            if(sum>h) return false;
        }
        return true;
    }
}