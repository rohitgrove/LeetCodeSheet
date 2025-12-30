class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Edge case
        if (k == n) {
            int sum = 0;
            for (int x : cardPoints) sum += x;
            return sum;
        }

        int windowSize = n - k;
        int totalSum = 0;

        for (int x : cardPoints) {
            totalSum += x;
        }

        int windowSum = 0;
        int minWindowSum = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            windowSum += cardPoints[right];

            if (right - left + 1 > windowSize) {
                windowSum -= cardPoints[left];
                left++;
            }

            if (right - left + 1 == windowSize) {
                minWindowSum = Math.min(minWindowSum, windowSum);
            }
        }

        return totalSum - minWindowSum;
    }
}