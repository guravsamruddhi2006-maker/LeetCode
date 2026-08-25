class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; ; i++) {
            int mul = k * i;

            if (!set.contains(mul)) {
                return mul;
            }
        }
    }
}