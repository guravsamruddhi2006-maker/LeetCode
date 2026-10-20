class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for (int start = 0; start < n; start += k) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int descents = 0;

                for (int j = 0; j < k; j++) {
                    int current = nums[start + j];
                    int next = nums[start + (j + 1) % k];

                    if (current > next) {
                        descents++;
                    }

                    min = Math.min(min, current);
                    max = Math.max(max, current);
                }

                if (descents > 1) {
                    valid = false;
                    break;
                }

                if (start > 0 && prevMax > min) {
                    valid = false;
                    break;
                }

                prevMax = max;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}