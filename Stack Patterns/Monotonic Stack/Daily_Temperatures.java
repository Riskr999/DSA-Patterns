class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        Arrays.fill(res,0);
        for(int i =0; i< temperatures.length; i++){
           
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int j = stack.pop();  // smaller value got popped
                res[j] = i-j;
                
            }
          //we push index here not value
            stack.push(i);
        }
        return res;
    }
}
