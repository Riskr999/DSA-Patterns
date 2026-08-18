class Solution {
    public int largestInteger(int[] nums, int k) {
       int[] freq = new int[51];
       for(int x : nums){
            freq[x]++;
       }

       if(k == 1){
        int max = -1;
        for(int x : nums){
            if(freq[x]==1){
                max = Math.max(max,x);
            }
        }
        return max;
       }
       if(k==nums.length){
        int  max=-1;
        for(int x: nums){
            max = Math.max(max,x);
        }
        return max;
       }

        int ans = -1;
        
        if(freq[nums[0]] == 1){
            ans =  Math.max(ans,nums[0]);
        }
        if(freq[nums[nums.length-1]]==1){
            ans =  Math.max(ans,nums[nums.length-1]);

        }
        
        
        return ans;
       




    }
}