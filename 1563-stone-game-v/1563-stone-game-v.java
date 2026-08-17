class Solution {

    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneVal) {

        int n = stoneVal.length;

        dp = new int[n][n];

        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneVal[i];
        }

        return Ascore(stoneVal, 0, n - 1);
    }

    private int Ascore(int[] stoneVal, int l, int r) {

        if (l == r) {
            return 0;
        }

        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        int maxscore = 0;

        for (int mid = l; mid < r; mid++) {

            int suml = prefix[mid + 1] - prefix[l];

            int sumr = prefix[r + 1] - prefix[mid + 1];

            int score;

            if (suml < sumr) {

                score = suml + Ascore(stoneVal, l, mid);

            } else if (sumr < suml) {

                score = sumr + Ascore(stoneVal, mid + 1, r);

            } else {

                score = Math.max(
                    suml + Ascore(stoneVal, l, mid),
                    sumr + Ascore(stoneVal, mid + 1, r)
                );
            }

            maxscore = Math.max(maxscore, score);
        }

        dp[l][r] = maxscore;

        return maxscore;
    }
}