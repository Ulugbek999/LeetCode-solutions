class Solution {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int m = n * n;

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int i = 1;


        while(left <= right && top <= bottom){

            //move left -> right;

            for(int col = left; col <= right; col++){
                result[top][col] = i++;
            }
            top++;

            //move top -> bottom
            for(int row = top; row <= bottom; row++){
                result[row][right] = i++;
            }

            right--;


            //move right -> left
            if(left <= right){
                for(int col = right; col >= left; col--){
                    result[bottom][col] = i++;
                }
            }

            bottom--;

            //move up
            if(top <= bottom){
                for(int row = bottom; row >= top; row--){
                    result[row][left] = i++;
                }
            }
            left++;


        }

        return result;
        
    }
}