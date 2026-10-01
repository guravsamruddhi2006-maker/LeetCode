class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, used, current, result);
        
        return result;
    }

    public void backtrack(int[] nums, boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {
        
        // permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // try every number
        for (int i = 0; i < nums.length; i++) {
            
            // already used
            if (used[i]) {
                continue;
            }

            // choose
            current.add(nums[i]);
            used[i] = true;

            // explore
            backtrack(nums, used, current, result);

            // undo choice (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}