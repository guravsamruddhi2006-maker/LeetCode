class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int max = 0;
        Arrays.sort(costs);
        for(int i = 0; i<n; i++){
            if(coins>=costs[i]){
                coins-=costs[i];
                max++;
            }else{
                break;
            }
        }
        return max;
        
    }
}