class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int countone = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                countone++;
            }

            // If there are more than k ones,
            // move left until exactly k ones remain
            while (countone > k) {
                if (s.charAt(left) == '1') {
                    countone--;
                }
                left++;
            }

            // We have exactly k ones
            if (countone == k) {

                // Remove unnecessary zeros from left
                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                // Shorter is better.
                // If same length, lexicographically smaller is better.
                if (current.length() < min ||
                    (current.length() == min && current.compareTo(ans) < 0)) {

                    min = current.length();
                    ans = current;
                }
            }
        }

        return ans;
    }
}