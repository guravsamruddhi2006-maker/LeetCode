class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            int key = nums[i];
            int val = i;
            if(map.containsKey(key)){
                int idx = map.get(key);
                if(Math.abs(val - idx)<=k){
                    return true;
                }
            }                
            map.put(key, val);
            
        }
        return false;
        
    }
}