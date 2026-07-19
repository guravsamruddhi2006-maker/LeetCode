class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;
            if(visited[ch - 'a']){
                continue;
            }
            
            while(!stack.isEmpty() && stack.peek() > ch && freq[stack.peek()-'a']>0){
                char remove = stack.pop();
                visited[remove - 'a'] = false;
                    
               
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}