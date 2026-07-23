class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // If there are less than 3 elements,
        // only the elements themselves can appear.
        if (n < 3) {
            return n;
        }

        // Count number of bits needed to represent n
        int bits = 0;
        int temp = n;

        while (temp > 0) {
            bits++;
            temp >>= 1;
        }

        return 1 << bits;
    }
}