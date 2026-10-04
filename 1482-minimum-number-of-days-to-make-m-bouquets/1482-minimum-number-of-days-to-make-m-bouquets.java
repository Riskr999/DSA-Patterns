class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long)m*k;
        int n = bloomDay.length;

        if(n<totalFlowers) return -1;

        int lo =Integer.MAX_VALUE,hi = 0;
        for(int i : bloomDay){
            lo = Math.min(lo,i);
        }
        for(int j : bloomDay){
            hi = Math.max(hi,j);
        }
        while(lo<hi){
            int mid = lo + (hi-lo)/2;

            if(check(bloomDay,m,mid,k)){
                hi = mid;
            }
            else{
                lo = mid+1;
            }

        }
        return lo;


    }
    private boolean check(int[] bloomDay,int m,int day,int k){
        int bouquets = 0;
        int streak = 0;

        for(int d : bloomDay){
            if(d<=day){
                streak++;
                if(streak==k){
                    bouquets++;
                    streak = 0;
                }
               
            }
            else{
                streak = 0;
            }
        }
        return bouquets>=m;
        
    }
}