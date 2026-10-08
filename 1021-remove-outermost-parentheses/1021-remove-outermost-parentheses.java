// class Solution {
//     public String removeOuterParentheses(String S) {
//         StringBuilder s = new StringBuilder();
//         int opened = 0;
//         for (char c : S.toCharArray()) {
//             if (c == '(' && opened++ > 0) s.append(c);
//             if (c == ')' && opened-- > 1) s.append(c);
//         }
//         return s.toString();
//     }
// }
class Solution {
    public String removeOuterParentheses(String s) {
        int sum = 0, start = 0, end = 0;
        StringBuilder res = new StringBuilder();

        while (end < s.length()) {
            if (s.charAt(end) == '(') sum++;
            else sum--;

            if (sum == 0) {
                res.append(s.substring(start + 1, end)); // exclude outer
                start = end + 1;
            }
            end++;
        }
        return res.toString();
    }
}