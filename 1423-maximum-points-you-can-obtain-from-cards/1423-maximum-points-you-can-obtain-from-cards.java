

class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // Step 1: Calculate total sum
        int total = 0;

        for (int x : cardPoints) {
            total += x;
        }

        // Step 2: Find how many cards we leave behind
        int windowSize = n - k;

        // If k == n, we take all cards
        if (windowSize == 0) {
            return total;
        }

        // Step 3: Sliding window
        int cur = 0;
        int min = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        while (r < n) {

            // Add right element
            cur += cardPoints[r];

            // If window becomes too large, remove from left
            while (r - l + 1 > windowSize) {
                cur -= cardPoints[l];
                l++;
            }

            // If window size is exactly n-k
            if (r - l + 1 == windowSize) {
                min = Math.min(min, cur);
            }

            r++;
        }

        // Maximum score = total - minimum cards left behind
        return total - min;
    }
}