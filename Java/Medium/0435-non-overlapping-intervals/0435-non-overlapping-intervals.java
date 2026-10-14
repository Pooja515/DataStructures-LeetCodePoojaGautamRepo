class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap: remove current interval
            if (intervals[i][0] < lastEnd) {
                removals++;
            } else {
                // No overlap: keep current interval
                lastEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
