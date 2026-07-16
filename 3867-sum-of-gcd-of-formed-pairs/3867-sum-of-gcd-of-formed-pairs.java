import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] mx = new int[n];
        int[] pregcd = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            mx[i] = max;
        }

        for (int i = 0; i < n; i++) {
            while (mx[i] != 0) {
                int gcd = nums[i] % mx[i];
                nums[i] = mx[i];
                mx[i] = gcd;

                if (mx[i] == 0)
                    pregcd[i] = nums[i];
                else
                    pregcd[i] = gcd;
            }
        }

        Arrays.sort(pregcd);

        long ans = 0;

        int i = 0;
        int j = n-1;

        while(i < j){

            int a = pregcd[i];
            int b = pregcd[j];

            while(b != 0){
                int temp = a % b;
                a = b;
                b = temp;
            }

            ans += a;

            i++;
            j--;
        }

        return ans;
    }
}