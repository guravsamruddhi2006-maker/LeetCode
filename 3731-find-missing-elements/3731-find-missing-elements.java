class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i]>max){
                max = nums[i];


            }if(nums[i]<min){
                min = nums[i];
            }

        }
        while(min<=max){
            Boolean found = false;
            for(int x : nums){
                if(x == min){
                    found = true;
                    break;
                }
            }
            if(!found)
                list.add(min);
            min++;
        }
        return list;
    }
}