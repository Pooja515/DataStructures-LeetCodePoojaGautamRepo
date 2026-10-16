class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int remove = 0;
        int n = intervals.length;

        int curr = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (curr > intervals[i][0]) {
                remove++;
            } else {
                curr = intervals[i][1];
            }
        }
        return remove;

    }
}