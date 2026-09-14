class Solution {
    private int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1}, {1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length, cols =grid[0].length;
       if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1) return -1;
        if (rows == 1) return 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        grid[0][0]=1;
        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int row = curr[0],col = curr[1];

                 if (row == rows-1 && col == cols-1) return steps;
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0&&newRow<rows&&newCol>=0&&newCol<cols&&grid[newRow][newCol]==0){
                    grid[newRow][newCol]=1;
                    queue.offer(new int[]{newRow,newCol});
                }
                
                
            }
            }
            steps++;
        }
        return -1;
    }
}