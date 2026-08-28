class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Step 1: Count frequency of each character
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Check whether palindrome is possible
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                middle = i;
            }
        }

        // More than one odd frequency -> impossible
        if (odd > 1) {
            return "";
        }

        // Step 3: Frequency of characters in left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        String answer = null;

        /*
         * Try every position where our palindrome
         * becomes greater than target.
         */
        for (int pos = 0; pos < halfLen; pos++) {

            int[] remaining = halfFreq.clone();

            StringBuilder left = new StringBuilder();

            boolean possible = true;

            // Make prefix equal to target
            for (int i = 0; i < pos; i++) {

                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                left.append(target.charAt(i));
                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            // At this position choose smallest character
            // strictly greater than target[pos]
            int targetChar = target.charAt(pos) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] == 0) {
                    continue;
                }

                StringBuilder candidateLeft =
                    new StringBuilder(left);

                candidateLeft.append((char) ('a' + c));

                remaining[c]--;

                // Fill remaining positions with smallest chars
                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        candidateLeft.append((char) ('a' + x));
                        remaining[x]--;
                    }
                }

                String candidate = buildPalindrome(
                    candidateLeft.toString(),
                    middle,
                    n
                );

                if (candidate.compareTo(target) > 0) {

                    if (answer == null ||
                        candidate.compareTo(answer) < 0) {

                        answer = candidate;
                    }
                }

                // First available greater character is enough
                break;
            }
        }

        /*
         * Case where the entire left half is equal to target.
         * The middle/right half may make the palindrome greater.
         */
        int[] remaining = halfFreq.clone();

        StringBuilder left = new StringBuilder();

        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {

            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            left.append(target.charAt(i));
            remaining[c]--;
        }

        if (possible) {

            String candidate = buildPalindrome(
                left.toString(),
                middle,
                n
            );

            if (candidate.compareTo(target) > 0) {

                if (answer == null ||
                    candidate.compareTo(answer) < 0) {

                    answer = candidate;
                }
            }
        }

        return answer == null ? "" : answer;
    }


    // Builds: left + middle + reverse(left)
    private String buildPalindrome(
        String left,
        int middle,
        int n
    ) {

        StringBuilder result = new StringBuilder();

        result.append(left);

        // Add middle character only for odd length
        if (n % 2 == 1) {
            result.append((char) ('a' + middle));
        }

        // Add reverse of left
        result.append(
            new StringBuilder(left).reverse()
        );

        return result.toString();
    }
}