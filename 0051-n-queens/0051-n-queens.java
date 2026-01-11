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
    // char[][] = {{'.','.','Q','.'},{},{}}

    private void backtrack(int row, char[][] board, List<List<String>> result){

        // for(int i = 0; i<board.length; i++){
        //     for(int j = 0; j<board[0].length; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

              
        if(row == board.length){
            List<String> copy = new ArrayList<>();
            for(char[] r : board){
                copy.add(new String(r));
            }
            result.add(copy);
            return;
        }
        
        for(int c = 0; c<board[0].length; c++){
            if(valid(row, c, board)){
                board[row][c] = 'Q';
                backtrack(row + 1, board, result);
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