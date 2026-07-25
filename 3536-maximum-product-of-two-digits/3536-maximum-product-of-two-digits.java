class Solution {
    public int maxProduct(int n) {
        int max = 0;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for(int i = 0; i<arr.length; i++){
            arr[i] = s.charAt(i)-'0';
        }
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                int num = arr[i]*arr[j];
                max = Math.max(max, num);
            }
        }
        return max;
        
        
    }
}
