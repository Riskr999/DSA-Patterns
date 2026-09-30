class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        if(nums.length==0){
            return 0;
        }
        long ans = 0, currentPairs = 0;
        int left = 0;
        Map<Integer,Integer> map1 = new HashMap<>();

        for(int right=0;right<n;right++){
            int count = map1.getOrDefault(nums[right],0);
            currentPairs += count;
            map1.put(nums[right],count+1);

            while(currentPairs>=k){
                ans += (nums.length-right);
                int leftCount = map1.get(nums[left]);
                currentPairs -= (leftCount-1);
                map1.put(nums[left], leftCount - 1);
                left++;
                
            }
        }
        return ans;
    }
}