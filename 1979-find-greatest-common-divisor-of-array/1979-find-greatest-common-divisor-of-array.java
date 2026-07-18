class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[n-1];
        int r = 0;
        while(b != 0){
            r = a%b;
            a = b;
            b = r;
        }if(b == 0){
            return a;
        }
        return 1;
    }
}