
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] sq = new long[nums.length];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(sq);

        int lft = 0;
        int rght = n - 1;
        long ans = 0;

        while (lft < rght) {
            ans += sq[rght] - sq[lft];
            lft++;
            rght--;
        }

        if (lft == rght) {
            ans += sq[lft];
        }

        return ans;
    }
}
