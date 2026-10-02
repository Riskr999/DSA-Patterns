class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        long ans = 0,currentPairs = 0;
        int left = 0;

        for(int right=0;right<n;right++){
            int count = map.getOrDefault(nums[right],0);
            currentPairs += count;
            map.put(nums[right],count+1);
            while(currentPairs>=k){
                ans += (n - right);
                int leftCount = map.get(nums[left]);
                currentPairs -= (leftCount-1);
                map.put(nums[left],leftCount-1);
                left++;
            }

        }
        return ans;
    }
}