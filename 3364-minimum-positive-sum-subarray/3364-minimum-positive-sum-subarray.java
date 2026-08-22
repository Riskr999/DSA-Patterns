class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n+1];
        int minSum = Integer.MAX_VALUE;

        for(int i =0;i<n;i++){
            prefix[i+1] = prefix[i]+nums.get(i);
        }

        for(int len = l;len<=r;len++){
            for(int i=0;i<=n-len;i++){
                int sum = prefix[i+len]-prefix[i];
                if(sum>0){
                    minSum = Math.min(minSum,sum);
                }
            }
        }

        return  (minSum==Integer.MAX_VALUE)?-1:minSum;
    }
}