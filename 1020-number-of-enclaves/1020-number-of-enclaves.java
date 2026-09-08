class Solution {
    private int[][] directions  ={{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid) {
        int rows = grid.length,cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if((r==0||r==rows-1||c==0||c==cols-1)&&grid[r][c]==1){
                    grid[r][c]=0;
                    queue.offer(new int[]{r,c});
                }
            }
        }
       
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];
            for(int[] dir:  directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0&&newRow<rows&&newCol>=0&&newCol<cols&&grid[newRow][newCol]==1){
                        grid[newRow][newCol]=0;
                        
                        queue.offer(new int[]{newRow,newCol});
                }
            }
        
        }
       int count = 0;
       for(int r=0;r<rows;r++){
        for(int c=0;c<cols;c++){
            if(grid[r][c]==1){
                count++;
            }
        }
       }
       return count;
    }
}