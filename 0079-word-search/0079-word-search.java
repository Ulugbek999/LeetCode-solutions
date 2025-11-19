class Solution {


    private int rows, cols;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c<cols; c++){
                if(dfs(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length()){
            return true;
        }
        //...stay within the board...................char != to the char of the word....checking for duplicates......
        if(r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r, c))){
            return false;
        }
    
        path.add(new Pair<>(r, c));//add the new pair...

        //checking all 4 directions, sorta like bfs.
        boolean res = dfs(board, word, r + 1, c, i+1) || dfs(board, word, r - 1, c, i+1) || dfs(board, word, r, c+1, i+1) || dfs(board, word, r, c - 1, i+1);

        //removing a choice we made ---> classic backtracking.
        path.remove(new Pair<>(r, c));


        return res;


    }


}