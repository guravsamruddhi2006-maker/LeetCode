class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> pair = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair.add(nums[i] ^ nums[j]);
            }
        }

        for (int x : pair) {
            for (int num : nums) {
                ans.add(x ^ num);
            }
        }

        return ans.size();
    }
}