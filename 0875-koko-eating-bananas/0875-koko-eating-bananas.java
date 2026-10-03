class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles){
            max = Math.max(max,p);
        }
        int lo =1, hi = max;

        while(lo<hi){
            int mid = lo + (hi-lo)/2;

            if(canEat(piles,h,mid)){
                hi = mid ;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
    private boolean canEat(int[] piles, int h,int k){
        long totalHours = 0;
        for(int pile : piles){
            totalHours += (pile+k-1)/k;
        }
        return totalHours<=h;

    }
}