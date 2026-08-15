class Solution {
    public void rotate(int[][] matrix) {


        //1. first row becomes last column
        //2. last row becomes first column

        //or take each column, flip it and make it a row;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int row = 0; row < rows; row++){
            for(int col = row+1; col < cols; col++){

                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;

            }
        }





        for(int row = 0; row < rows; row++){
            matrix[row] = reverse(matrix[row]);
        }

        
        
    }

    private int[] reverse(int[] subArr){

        int[] result = new int[subArr.length];
        int j = 0;
        for(int i = subArr.length-1; i>=0;i--){
            result[j++] = subArr[i];
        }

        return result;


    }
}