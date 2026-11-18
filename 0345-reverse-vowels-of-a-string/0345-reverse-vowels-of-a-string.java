class Solution {
    public String reverseVowels(String s) {
        StringBuilder result = new StringBuilder(s);
        StringBuilder vowels = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowels.append(c);
        }

        int i = vowels.length() - 1;
        for (int j = 0; j < s.length(); j++) {
            if (isVowel(s.charAt(j))) {
                result.setCharAt(j, vowels.charAt(i--));
            }
        }

        return result.toString();
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}