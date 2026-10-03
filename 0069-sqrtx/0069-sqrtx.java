class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;

        int lo = 2, hi = x/2;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            if(mid>x/mid){
                hi = mid-1;
            }
            else if(mid<x/mid){
                lo = mid+1;
            }
            else{
                return mid;
            }
        }
        return hi;
    }
}