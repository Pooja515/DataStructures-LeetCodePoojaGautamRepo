class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, maxi = 0, n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
            maxi = lsum;
        }
        int r = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lsum -= cardPoints[i];
            rsum += cardPoints[r--];
            maxi = Math.max(maxi, (lsum + rsum));
        }
        return maxi;

    }
}