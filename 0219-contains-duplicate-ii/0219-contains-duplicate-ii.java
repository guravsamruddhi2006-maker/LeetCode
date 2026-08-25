// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         int n = nums.length;
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i<n; i++){
//             int key = nums[i];
//             int val = i;
//             if(map.containsKey(key)){
//                 int idx = map.get(key);
//                 if(Math.abs(val - idx)<=k){
//                     return true;
//                 }
//             }                
//             map.put(key, val);
            
//         }
//         return false;
        
//     }
// }
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Keep window size <= k
            if (right - left > k) {
                set.remove(nums[left]);
                left++;
            }

            // Duplicate inside current window
            if (set.contains(nums[right])) {
                return true;
            }

            set.add(nums[right]);
        }

        return false;
    }
}