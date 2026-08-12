class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum=0,currmaxsum =0,currminsum=0;
        int maxi= Integer.MIN_VALUE , mini = Integer.MAX_VALUE;

        for(int num : nums){
            totalsum += num;
            currmaxsum += num;
            currminsum += num;

            maxi= Math.max(maxi,currmaxsum);

            if(currmaxsum < 0){
                currmaxsum = 0;
            }

            mini = Math.min(mini,currminsum);


            if(currminsum > 0){
                currminsum = 0;
            }

        }

        if(maxi < 0) return maxi;
        int circularsum = totalsum - mini;

        return Math.max(maxi,circularsum);
    }
}