class Solution{
    public int trap(int[] height){
      Deque<Integer> stack = new ArrayDeque<>();
      int  total_water= 0;

      for(int i =0; i<height.length; i++){

        while(!stack.isEmpty() && height[i]> height[stack.peek()]{
          int floor_idx = stack.pop();
          if(stack.isEmpty()) break;
          int leftWallIdx = stack.peek()
          int width = i - leftWallIdx - 1;
          int boundedHeight = Math.min(height[leftWallIdx],height[i]) - height[floor_idx];
          total_water += width * boundedheight;
        }
        
        stack.push(i);      
      }
      return total_water;
    
    }

  
}
