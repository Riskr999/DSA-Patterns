class Solution {
    public int minimumDeletions(int[] nums) {
        int  n =nums.length;
        if(n<2){
            return n;

        }
        int maxIdx = 0;
        int minIdx = 0;

        for(int i =0;i<n;i++){
            if(nums[i]>nums[maxIdx]) maxIdx = i;
            if(nums[i]<nums[minIdx]) minIdx = i;
        }
        int first = Math.min(minIdx, maxIdx);
        int second = Math.max(minIdx, maxIdx);

        int frontonly = second+1;

        int backonly = n-first;
        int bothside = (first+1) + (n-second);

        return Math.min(frontonly, Math.min(backonly, bothside));
    }
}