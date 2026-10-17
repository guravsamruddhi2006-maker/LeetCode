
import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = arr[i][0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || nums[i] == sorted[i]) {
                continue;
            }

            int j = i;
            int count = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(sorted[j]);
                count++;
            }

            swaps += count - 1;
        }

        return swaps;
    }
}
