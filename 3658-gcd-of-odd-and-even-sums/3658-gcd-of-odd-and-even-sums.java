class Solution {
    public int gcdOfOddEvenSums(int n) {
        int i = 1, count1 = 1, count2 = 1;
        int sodd = 0, seven = 0;
        while(count1 <=n && count2<=n){
            if(i%2 == 0){
                seven += i; 
                count1++;
            }else{
                sodd += i;
                count2++;
            }
        }
        if(seven != 0){
            int r = sodd%seven;
            sodd = r;
            seven = sodd;
        }
        return sodd;
        //GCD(sodd, seven);
    
    //public int GCD(int sodd, int seven){
        

    }
    
}