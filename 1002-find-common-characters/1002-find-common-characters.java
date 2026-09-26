
class Solution {
    public List<String> commonChars(String[] words) {

        HashMap<Character, Integer> map1 = new HashMap<>();

        // Count characters of first word
        for (char ch : words[0].toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Compare with every other word
        for (int i = 1; i < words.length; i++) {

            HashMap<Character, Integer> map2 = new HashMap<>();

            // Count characters of current word
            for (char ch : words[i].toCharArray()) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }

            // Update map1 with minimum frequency
            for (char ch : map1.keySet()) {

                if (map2.containsKey(ch)) {
                    int min = Math.min(map1.get(ch), map2.get(ch));
                    map1.put(ch, min);
                } else {
                    map1.put(ch, 0);
                }
            }
        }

        // Create answer
        List<String> result = new ArrayList<>();

        for (char ch : map1.keySet()) {

            int count = map1.get(ch);

            while (count > 0) {
                result.add(String.valueOf(ch));
                count--;
            }
        }

        return result;
    }
}
