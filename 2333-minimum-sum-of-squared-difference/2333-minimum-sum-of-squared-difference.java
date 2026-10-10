
class Solution {
    public long minSumSquareDiff(int[] n1, int[] n2, int k1, int k2) {
        int maxdif = 0;
        long totaldif = 0;
        int n = n1.length;
        int[] freq = new int[100001];

        for (int i = 0; i < n; i++) {
            int dif = Math.abs(n1[i] - n2[i]);
            maxdif = Math.max(maxdif, dif);
            freq[dif]++;
            totaldif += dif;
        }

        long k = (long) k1 + k2;

        if (totaldif <= k) {
            return 0;
        }

        for (int i = maxdif; i > 0 && k > 0; i--) {
            int move = (int) Math.min(k, freq[i]);

            freq[i] -= move;
            freq[i - 1] += move;
            k -= move;
        }

        long ans = 0;

        for (int i = 1; i <= maxdif; i++) {
            ans += (long) i * i * freq[i];
        }

        return ans;
    }
}
