class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));

        int remove=0;
        int currelementlast=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(currelementlast>intervals[i][0]) remove++;
            else{
                currelementlast = intervals[i][1];
            }
        }
        return remove;
    }
}
