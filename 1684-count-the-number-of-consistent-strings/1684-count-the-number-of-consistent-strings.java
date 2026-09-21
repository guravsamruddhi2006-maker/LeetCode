class Solution {
    public int countConsistentStrings(String aled, String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            boolean iscontains = true;

            for (char ch : words[i].toCharArray()) {
                if (aled.indexOf(ch) == -1) {
                    iscontains = false;
                    break;
                }
            }

            if (iscontains) {
                count++;
            }
        }

        return count;
    }
}