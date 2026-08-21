import java.util.*;

class Solution {

    public long findKthSmallest(int[] coins, int k) {

        // Remove duplicate coins
        HashSet<Integer> set = new HashSet<>();

        for (int coin : coins) {
            set.add(coin);
        }

        int[] arr = new int[set.size()];
        int index = 0;

        for (int coin : set) {
            arr[index++] = coin;
        }

        int minCoin = Integer.MAX_VALUE;

        for (int coin : arr) {
            minCoin = Math.min(minCoin, coin);
        }

        long left = 1;
        long right = (long) minCoin * k;

        while (left < right) {

            long mid = left + (right - left) / 2;

            // Only 2 arguments
            long count = countValid(mid, arr);

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long countValid(long x, int[] coins) {

        int n = coins.length;
        long count = 0;

        // All possible subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcmValue = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    // Explicitly convert int to long
                    lcmValue = lcm(lcmValue, (long) coins[i]);

                    if (lcmValue > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) {
                continue;
            }

            long current = x / lcmValue;

            if (bits % 2 == 1) {
                count += current;
            } else {
                count -= current;
            }
        }

        return count;
    }

    private long lcm(long a, long b) {

        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        while (b != 0) {

            long temp = a % b;

            a = b;
            b = temp;
        }

        return a;
    }
}