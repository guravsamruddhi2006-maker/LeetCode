// class Solution {
//     public int maxSubarrayLength(int[] nums, int k) {
//         int n = nums.length;
//         int l = 0;
//         int maxlength = 0;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i<n; i++){
//             map.put(nums[i], map.getOrDefault(nums, 0)+1);
//             while(map.get(nums[i])>k){
//                 map.put(nums[l], map.get(nums[l])-1);
//                 l++;
//             }

//             maxlength = Math.max(maxlength, i-l+1);
//         }
//         return maxlength;
//     }
// }
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right]
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window if frequency exceeds k
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}