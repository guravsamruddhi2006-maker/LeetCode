class Solution {
    public int minimumPushes(String word) {
        int cost = 0;

        int[] freq = new int[26];
        for(char ch : word.toCharArray()){
            freq[ch -'a']++;
        }
        Arrays.sort(freq);
        int pos = 0;
        for(int i = 25; i>=0; i--){
            if(freq[i] == 0)break;
            cost += freq[i]*(pos/8+1);
            pos++;
        }
        return cost;
    }
}
