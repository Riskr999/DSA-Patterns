class Solution {
    private static final int[][]  DIRECTION = {{-1,0},{1,0},{0,-1},{0,1}};
    public int orangesRotting(int[][] grid) {
        if(grid==null||grid.length == 0) return 0;
        int minutes = 0;
        int freshCounts = 0;
        int row  = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r=0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r,c});
                }
                else if(grid[r][c] == 1){
                    freshCounts++;
                }
            }
        }

        if(freshCounts == 0) return 0;

        while(!queue.isEmpty()&& freshCounts>0){
            int size = queue.size();
            for(int i =0;i<size;i++){
                int[] current = queue.poll();
                int currRow = current[0];
                int currCol = current[1];

                for(int[] dir : DIRECTION){
                   int newRow = currRow + dir[0];
                   int newCol = currCol + dir[1];

                    if(newRow>=0 && newRow<grid.length
                     && newCol>=0 && newCol<grid[0].length &&
                     grid[newRow][newCol] == 1){

                        grid[newRow][newCol] = 2;
                        freshCounts--;
                        queue.offer(new int[]{newRow,newCol});
                    }
                    

                }
                


            }
            minutes++;
        }
        return freshCounts == 0 ? minutes : -1;
        
    }
}