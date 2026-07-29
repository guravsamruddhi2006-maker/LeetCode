class Solution {

    private static final long LIMIT = 1_000_000L;

    public String smallestPalindrome(String s, int k) {

        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] half = new int[26];
        String mid = "";

        int len = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];

            if ((freq[i] & 1) == 1) {
                mid = String.valueOf((char) ('a' + i));
            }
        }

        // Total number of palindromes
        if (countWays(half, len) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        while (len > 0) {

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = countWays(half, len - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    len--;
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    // Number of distinct permutations of remaining multiset
    private long countWays(int[] cnt, int total) {

        long res = 1;
        int rem = total;

        for (int x : cnt) {

            if (x == 0)
                continue;

            res *= combination(rem, x);

            if (res > LIMIT)
                return LIMIT;

            rem -= x;
        }

        return Math.min(res, LIMIT);
    }

    // nCr (clamped to LIMIT)
    private long combination(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - r + i) / i;

            if (ans > LIMIT)
                return LIMIT;
        }

        return ans;
    }
}