
class Solution {
    public int singleNumber(int[] nums) {
        // if(nums.length == 1)return nums[0];
        // Arrays.sort();

        // for(int i = 0; i<nums.length-1; i+=2){
        //     if(nums[i] != nums[i+1]){
        //         return nums[i];
                
        //     }
        // }
        // return nums[nums.length-1];

        HashMap<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);
}

for (int num : map.keySet()) {
    if (map.get(num) == 1) {
        return num;
    }
}

return -1;
    }
}