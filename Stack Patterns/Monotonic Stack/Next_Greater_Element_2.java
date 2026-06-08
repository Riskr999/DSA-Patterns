class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        for(int i = 0;i <2*n;i++){
            int idx = i%n;
          while(!stack.isEmpty() && nums[stack.peek()]<nums[idx]){
                    result[stack.pop()] = nums[idx];
            }
            if (i < n) stack.push(idx);
        }
        return result;
    }

        
    
}
