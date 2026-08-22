class Solution {
    public boolean checkDivisibility(int n) {
        int ori = n;
        int sum = 0;
        int prod = 1;

        while (ori > 0) {
            int dig = ori % 10;

            sum += dig;
            prod *= dig;

            ori /= 10;
        }

        if (n % (sum + prod) == 0) {
            return true;
        }

        return false;
    }
}