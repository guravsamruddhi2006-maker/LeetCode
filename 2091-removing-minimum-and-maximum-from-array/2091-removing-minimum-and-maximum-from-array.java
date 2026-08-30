class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max =nums[0];
        int min = nums[0];
        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 1; i<n; i++){
            if(nums[i]<min){
                min = nums[i];
                minIndex = i;
            }
            if(nums[i]>max){
                max = nums[i];
                maxIndex = i;
            }
        }
        int option1 = Math.max(minIndex, maxIndex) + 1;
        int option2 = nums.length - Math.min(minIndex, maxIndex);
        int option3 = Math.min(minIndex, maxIndex) + 1
            + nums.length - Math.max(minIndex, maxIndex);

        return Math.min(option1, Math.min(option2, option3));
    }
}