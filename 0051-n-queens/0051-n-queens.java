class Solution {
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] r: board){
            Arrays.fill(r,'.');

        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        backtracking(n,0,board,cols,diag1,diag2,result);
        return result;
        
    }
    private void backtracking(int n , int row, char[][] board,Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, List<List<String>>result ){
        
        if(row == n){
            
            List<String> Solution = new ArrayList<>();
            for(char[] r: board){
                Solution.add(new String(r));
                

            }
            result.add(Solution);
            return;
        }

        for(int col = 0; col<n;col++){
            if(!cols.contains(col)&&!diag1.contains(row-col)&&!diag2.contains(row+col)){
                board[row][col] = 'Q';
                cols.add(col);
                diag1.add(row-col);
                diag2.add(row+col);

                backtracking(n,row+1,board,cols,diag1,diag2,result);
                board[row][col] = '.';
                cols.remove(col);
                diag1.remove(row-col);
                diag2.remove(row+col);

                

            }
        }
       
    }
}