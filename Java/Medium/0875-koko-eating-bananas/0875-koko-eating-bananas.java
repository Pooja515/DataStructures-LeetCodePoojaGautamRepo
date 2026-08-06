class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1,high = 0;

        for(int i=0;i<piles.length;i++){
           
            high = Math.max(high,piles[i]);

        }
    
        while(low <= high){
            int mid = low+(high-low)/2;

            if(isPossible(piles,mid,h)){
                high=mid-1;
            }
            else
                   low=mid+1;
        }
        return low;
    }
    boolean isPossible(int[] piles,int mid,int h){
        long sum=0;
        for(int i=0;i<piles.length;i++){
            sum+=(piles[i])/mid;
            if(piles[i]%mid !=0)
                  sum++;  
           if(sum > h) return false;
        }
        return true;
    }
}