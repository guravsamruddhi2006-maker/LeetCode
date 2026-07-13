import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();

        for (int start = 1; start <= 9; start++) {
            int current = start;

            for (int next = start + 1; next <= 9; next++) {
                current = current * 10 + next;

                if (current >= low && current <= high) {
                    list.add(current);
                }
            }
        }

        Collections.sort(list);
        return list;
    }
}