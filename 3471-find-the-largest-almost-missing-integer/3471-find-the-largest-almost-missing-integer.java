class Solution {

    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int left = 0; left <= n - k; left++) {

            HashSet<Integer> set = new HashSet<>();

            for (int i = left; i < left + k; i++) {
                set.add(nums[i]);
            }

            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int answer = -1;

        for (int num : map.keySet()) {

            if (map.get(num) == 1) {
                answer = Math.max(answer, num);
            }
        }

        return answer;
    }
}