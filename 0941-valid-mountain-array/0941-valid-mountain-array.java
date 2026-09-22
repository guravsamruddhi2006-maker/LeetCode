class Solution {
    public boolean validMountainArray(int[] arr) {

        if(arr.length < 3){
            return false;
        }

        int i = 0;

        // Increasing
        while(i < arr.length - 1 && arr[i] < arr[i + 1]){
            i++;
        }

        // Peak cannot be first or last
        if(i == 0 || i == arr.length - 1){
            return false;
        }

        // Decreasing
        while(i < arr.length - 1 && arr[i] > arr[i + 1]){
            i++;
        }

        return i == arr.length - 1;
    }
}