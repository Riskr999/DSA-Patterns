class Solution {
    public void solveSudoku(char[][] board) {
        
         Solve(board);
        
    }
    private boolean Solve(char[][] board){
        for(int col=0;col<9;col++){
            for(int row=0;row<9;row++){
                if(board[row][col]=='.'){
                    for(char c = '1'; c<='9';c++){
                        if(IsValid(board,row,col,c)){
                            board[row][col] = c;
                        
                        if(Solve(board)) return true;

                        board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean IsValid(char[][] board,int row, int col,char c){
       for(int i =0;i<9;i++){

            if(board[row][i] == c) return false;

            if(board[i][col]==c) return false;

            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;

       }
       return true;
    }
}