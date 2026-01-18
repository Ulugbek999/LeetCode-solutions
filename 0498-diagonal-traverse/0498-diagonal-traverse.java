class Solution {
  public int[] findDiagonalOrder(int[][] matrix) {

    int direction = 1;
    int[] result = new int[matrix.length * matrix[0].length];
    int i = 0;
    boolean up = true;
    int row = 0;
    int col =0;
    while(row < matrix.length && col < matrix[0].length){
        if(up){
            //going up:
            while(row > 0 && col < matrix[0].length-1){
                result[i++] = matrix[row][col];
                row--;
                col++;  
            }
            result[i++] = matrix[row][col];
            //if it is the last column
            if(col == matrix[0].length-1){
                row++;
            }else{
                col++;
            }

        }else{
            //going down:
            while(col > 0 && row < matrix.length-1){
                result[i++] = matrix[row][col];
                row++;
                col--;
            }
            result[i++] = matrix[row][col];
            if(row == matrix.length-1){
                col++;
            }else{
                row++;
            }
                
        }
        up = !up;
    }
    
    return result;

  }
}