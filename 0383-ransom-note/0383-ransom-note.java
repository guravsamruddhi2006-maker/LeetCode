class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] arr = new int[26];

        for (int ch : magazine.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int ch : ransomNote.toCharArray()) {

            arr[ch - 'a']--;

            if (arr[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}