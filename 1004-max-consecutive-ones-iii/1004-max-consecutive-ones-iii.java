class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int countzero = 0;
        int max = 0;
        for(int r = 0; r<nums.length; r++){
            if(nums[r] == 0){
                countzero++;
            }
            while(countzero > k){
                if(nums[l] == 0){
                    countzero--;
                }
                l++;
            }
            max = Math.max(max, r-l+1);

        }
        return max;
    }
}