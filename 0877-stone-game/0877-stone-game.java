class Solution {
    public boolean stoneGame(int[] piles) {
    //     return solve(piles, 0, piles.length)>=0;
    // }
    // int solve(int[] piles, int l, int r){
    //     if(l==r)
    //         return piles[l];
    //     int takeleft = piles[l]-solve(piles, l+1, r);
    //     int takeright = piles[r]-solve(piles, l, r-1);
    //     return Math.max(takeleft, takeright);
        return true;
    }
}