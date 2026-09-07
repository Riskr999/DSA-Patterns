class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        int rows = board.length,cols= board[0].length;

        Queue<int[]> queue = new LinkedList<>();


        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if((r==0||r==rows-1||c==0||c==cols-1)&& board[r][c]=='O'){
                    queue.offer(new int[]{r,c});
                    board[r][c]='#';
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];

            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow>=0&&newRow<rows&&newCol>=0&&newCol<cols&&board[newRow][newCol]=='O'){
                    board[newRow][newCol]='#';
                    queue.offer(new int[]{newRow,newCol});
                   
            
                }
                

            }

        }
        for(int r = 0;r<rows;r++){
            for(int c = 0;c<cols;c++){
                if(board[r][c]=='O') board[r][c]='X';
                else if(board[r][c]=='#') board[r][c]='O';
            }
        }

    }
}