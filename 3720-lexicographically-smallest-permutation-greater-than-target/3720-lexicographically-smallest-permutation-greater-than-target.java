class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        // Frequency of characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Try every position from right to left
        for (int i = n - 1; i >= 0; i--) {

            // We will rebuild the prefix target[0...i-1]
            int[] count = freq.clone();

            boolean possible = true;

            // Use same characters as target for prefix
            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';

                if (count[idx] == 0) {
                    possible = false;
                    break;
                }

                count[idx]--;
            }

            if (!possible) {
                continue;
            }

            // At position i, find smallest character
            // greater than target[i]
            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Prefix same as target
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }

                    // Put greater character
                    ans.append((char) ('a' + c));
                    count[c]--;

                    // Put remaining characters in sorted order
                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}