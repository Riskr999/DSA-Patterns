class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int maxLength = 0;
        for(int s : set){
            if(!set.contains(s-1)){
                int currentNum = s;
                int length = 1;

                while(set.contains(currentNum+1)){
                    currentNum++;
                    length++; 
                }

                maxLength = Math.max(maxLength,length);


            }
        }
    return maxLength;
    
    }
}