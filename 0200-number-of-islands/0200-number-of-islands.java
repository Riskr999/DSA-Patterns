class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length ==0) return 0;

        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r = 0; r<rows;r++){
            for(int c = 0;c<cols;c++){
                if(grid[r][c] == '1'){
                    islands++;
                    dfs(grid,r,c);

                }

            }
            
        }
        return islands;


        
    }
    private static final int[][] direction = {{-1,0}, {1,0}, {0,-1},{0,1}};

    private void dfs(char[][] grid,int r,int c){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';

        for(int[] dir: direction){
            int newrow = r + dir[0];
            int newcol = c + dir[1];
            dfs(grid,newrow,newcol); 
        }
    }
}