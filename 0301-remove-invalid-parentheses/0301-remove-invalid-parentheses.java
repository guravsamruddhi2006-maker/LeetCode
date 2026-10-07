class Solution {

    List<String> list = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // Find extra '(' and ')'
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            }

            else if (s.charAt(i) == ')') {

                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        // Start removing
        remove(s, 0, left, right);

        return list;
    }

    private void remove(String s, int start, int left, int right) {

      
        if (left == 0 && right == 0) {

            if (isValid(s)) {
                if (!list.contains(s)) {
                    list.add(s);
                }
            }

            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Skip duplicate parentheses
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

           
            if (s.charAt(i) == '(' && left > 0) {

                String newString =
                    s.substring(0, i) + s.substring(i + 1);

                remove(newString, i, left - 1, right);
            }

           
            else if (s.charAt(i) == ')' && right > 0) {

                String newString =
                    s.substring(0, i) + s.substring(i + 1);

                remove(newString, i, left, right - 1);
            }
        }
    }

    private boolean isValid(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                count++;
            }

            else if (s.charAt(i) == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}