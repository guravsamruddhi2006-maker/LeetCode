class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        for(int num : sorted){
            if(!map.containsKey(num)){
                map.put(num, rank++);
            }
        }
        for(int i = 0; i<arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}