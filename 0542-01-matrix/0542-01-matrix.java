class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length,cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int r = 0;r<rows;r++){
            for(int c =0;c<cols;c++){
                if(mat[r][c]==0){
                    queue.offer(new int[]{r,c});
                }
                else{
                    mat[r][c]=-1;
                }
            }
        }

        while(!queue.isEmpty()){
            //processing the individual node
            int[] curr = queue.poll();
            int row = curr[0],col = curr[1];

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];


                if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && mat[newRow][newCol]==-1){
                    mat[newRow][newCol] = mat[row][col]+1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }

        }
        return mat;



    }

}