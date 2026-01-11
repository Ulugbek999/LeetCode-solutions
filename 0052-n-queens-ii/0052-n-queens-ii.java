class Solution {
    public int totalNQueens(int n) {
    


        char[][] board = new char[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        int[] number = new int[1];
        backtrack(0, board, number);

        return number[0];



    }
    // char[][] = {{'.','.','Q','.'},{},{}}

    private void backtrack(int row, char[][] board, int[] number){
              
        if(row == board.length){
                number[0]++;
            return;
        }
        
        for(int c = 0; c<board[0].length; c++){
            if(valid(row, c, board)){
                board[row][c] = 'Q';
                backtrack(row + 1, board, number);
                board[row][c] = '.';
            }
        }
    }

    private boolean valid(int r, int c, char[][] board){
        //to check the vertical
        for(int i = r; i>=0;i--){
            if(board[i][c] == 'Q') return false;
        }

        //check the horizontal
        for(int i = c; i>= 0; i--){
            if(board[r][i] == 'Q') return false;
        }

        //check the left diagonal
        for(int i = r, j = c; i >= 0 && j < board[0].length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        //check the right diagonal
        for(int i = r, j = c; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }    
        return true;   
    }

}