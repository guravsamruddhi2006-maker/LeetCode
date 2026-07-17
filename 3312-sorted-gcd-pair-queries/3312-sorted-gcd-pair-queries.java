class Solution {

    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] freq = new int[max + 1];

        for (int x : nums)
            freq[x]++;

        int[] cnt = new int[max + 1];

        for (int g = 1; g <= max; g++) {
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt[g] += freq[multiple];
            }
        }

        long[] gcdCount = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            gcdCount[g] = 1L * cnt[g] * (cnt[g] - 1) / 2;

            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                gcdCount[g] -= gcdCount[multiple];
            }
        }

        long[] prefix = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + gcdCount[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int low = 1;
            int high = max;

            while (low < high) {

                int mid = (low + high) / 2;

                if (prefix[mid] > queries[i])
                    high = mid;
                else
                    low = mid + 1;
            }

            ans[i] = low;
        }

        return ans;
    }
}