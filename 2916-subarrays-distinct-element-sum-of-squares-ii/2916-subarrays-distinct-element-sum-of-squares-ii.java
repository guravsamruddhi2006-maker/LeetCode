
import java.util.*;

class Solution {
    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] sq;
    long[] lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long ans = 0;

        for (int r = 0; r < n; r++) {
            int x = nums[r];

            update(1, 0, n - 1, last[x] + 1, r);
            last[x] = r;

            ans = (ans + query(1, 0, n - 1, 0, r)) % MOD;
        }

        return (int) ans;
    }

    void apply(int node, int left, int right, long val) {
        long len = right - left + 1;

        sq[node] = (sq[node] + 2 * val * sum[node]
                    + val * val % MOD * len) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;

        apply(node * 2, left, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, right, lazy[node]);

        lazy[node] = 0;
    }

    void pull(int node) {
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }

    void update(int node, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) {
            return;
        }

        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        update(node * 2, left, mid, ql, qr);
        update(node * 2 + 1, mid + 1, right, ql, qr);

        pull(node);
    }

    long query(int node, int left, int right, int ql, int qr) {
        if (ql > right || qr < left) {
            return 0;
        }

        if (ql <= left && right <= qr) {
            return sq[node];
        }

        push(node, left, right);

        int mid = left + (right - left) / 2;

        long a = query(node * 2, left, mid, ql, qr);
        long b = query(node * 2 + 1, mid + 1, right, ql, qr);

        return (a + b) % MOD;
    }
}
