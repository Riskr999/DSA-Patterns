class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int windowSum=0;
        double maxAvg = 0.0;

        for(int i=0;i<k;i++ ){
            windowSum += nums[i];

        }
        maxAvg = (double) windowSum/k;
        for(int r = k;r<nums.length;r++){
            windowSum += nums[r]-nums[r-k];
            double avg = (double) windowSum/k;

            maxAvg = Math.max(maxAvg,avg);
        }
        return maxAvg;

    }
}