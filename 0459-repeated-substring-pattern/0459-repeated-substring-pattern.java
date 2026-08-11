class Solution {
    public boolean repeatedSubstringPattern(String s) {
       int n = s.length();
       for(int i = 1; i<=n/2; i++){
        if(n%i != 0){
            continue;
        }
       
       String pat = s.substring(0, i);
       StringBuilder ref = new StringBuilder();
       while(ref.length()<n){
        ref.append(pat);
       }
       if(ref.toString().equals(s)){
        return true;
       }
       }
       return false;

    }
}