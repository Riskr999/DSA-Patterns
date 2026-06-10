class Solution {
   public  int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        
        
        for(int i =0; i<=heights.length; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            
            while (!stack.isEmpty()&& heights[stack.peek()]>=currentHeight){
                
                int target = stack.pop();
                int height = heights[target];
                int width =  stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height* width;
                maxArea = Math.max(maxArea, area);

            }
            
            stack.push(i);
            
        }
        
        return maxArea;

    }
}
