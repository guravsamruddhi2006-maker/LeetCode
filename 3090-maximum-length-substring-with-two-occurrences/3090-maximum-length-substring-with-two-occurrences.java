class Solution {
    public int maximumLengthSubstring(String s) {
        int count = 0;
        int maxlength = 0;
        int[] charcount = new int[26];
        for(int i = 0; i<s.length(); i++){
            charcount[s.charAt(i) - 'a']++;
            while(charcount[s.charAt(i) - 'a'] >2){
                charcount[s.charAt(count++)-'a']--;
                
            }
            maxlength = Math.max(maxlength, i-count+1);

        }
        return maxlength;
    }
}