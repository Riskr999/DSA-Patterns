class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int islands = 0;
        for(int r =0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]=='1'){
                    islands++;
                    dfs(grid,r,c);
                }
            }
        }
        return islands;

    }
    private int[][] directions = {{-1,0}, {1,0}, {0,-1},{0,1}};

    private void dfs(char[][] grid, int r ,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[0].length||grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';

        for(int[] dir : directions){
            int newRow = r +dir[0];
            int newCol = c + dir[1];
            dfs(grid,newRow,newCol);
        }

    }
    
}