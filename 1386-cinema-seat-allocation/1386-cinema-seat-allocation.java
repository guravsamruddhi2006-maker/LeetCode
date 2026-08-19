import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {

            int row = seat[0];
            int col = seat[1];

            // Seats 1 and 10 don't affect the answer
            if (col >= 2 && col <= 9) {
                map.putIfAbsent(row, new HashSet<>());
                map.get(row).add(col);
            }
        }

        int answer = (n - map.size()) * 2;

        // Check only rows having reservations
        for (int row : map.keySet()) {

            HashSet<Integer> seats = map.get(row);

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            // Check 2,3,4,5
            for (int i = 2; i <= 5; i++) {
                if (seats.contains(i)) {
                    left = false;
                }
            }

            // Check 4,5,6,7
            for (int i = 4; i <= 7; i++) {
                if (seats.contains(i)) {
                    middle = false;
                }
            }

            // Check 6,7,8,9
            for (int i = 6; i <= 9; i++) {
                if (seats.contains(i)) {
                    right = false;
                }
            }

            if (left && right) {
                answer += 2;
            }
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}