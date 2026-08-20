class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];

        int size1 = 1;
        int size2 = 1;

        for(int i = 2; i < n; i++) {

            if(arr1[size1 - 1] > arr2[size2 - 1]) {
                arr1[size1] = nums[i];
                size1++;
            } 
            else {
                arr2[size2] = nums[i];
                size2++;
            }
        }

        // Put arr2 after arr1
        for(int i = 0; i < size2; i++) {
            arr1[size1 + i] = arr2[i];
        }

        return Arrays.copyOf(arr1, size1 + size2);
    }
}