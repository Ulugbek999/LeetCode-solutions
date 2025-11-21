class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }    
        backtrack(0, board, result);
        return result;

    }

    private void backtrack(int r, char[][] board, List<List<String>> result){
        if(r == board.length){
            List<String> copy = new ArrayList<>();
            for(char[] row : board){
                copy.add(new String(row)); //basically add each row once we are finished;
            }
            result.add(copy);
            return;
        }


        for(int c = 0; c<board.length; c++){
            if(isSafe(r, c, board)){
                board[r][c] = 'Q'; //place a queen
                backtrack(r + 1, board, result); //move on to the next row;
                board[r][c] = '.'; //explore other pocibilities.
            }
        }

    }

    private boolean isSafe(int r, int c, char[][] board){

        //checking the rows above the current collumn, so moving up and checking if there is a Queen placed in there
        for(int i = r-1; i>= 0; i--){
            if(board[i][c] == 'Q') return false;
        }

        //checking the diagonals, direction: right-bottom to left-top:
        for(int i = r-1, j = c-1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        //checking the diagonal, direction: up and right, so think left-bottom corner to right-upper corner:
        for(int i = r - 1, j = c + 1; i >= 00 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        
        return true;

    }

}