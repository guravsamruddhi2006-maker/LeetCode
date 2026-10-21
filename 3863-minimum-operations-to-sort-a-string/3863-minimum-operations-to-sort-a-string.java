class Solution {
    public int minOperations(String s) {
        int n = s.length();

        if (n == 1) {
            return 0;
        }

        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char min = s.charAt(0);
        char max = s.charAt(0);

        for (int i = 1; i < n; i++) {
            min = (char) Math.min(min, s.charAt(i));
            max = (char) Math.max(max, s.charAt(i));
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min) {
            for (int i = 1; i < n - 1; i++) {
                if (s.charAt(i) == max || s.charAt(i) == min) {
                    return 2;
                }
            }
            return 3;
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        return 2;
    }
}