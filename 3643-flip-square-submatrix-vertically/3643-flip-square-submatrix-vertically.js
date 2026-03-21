/**
 * @param {number[][]} grid
 * @param {number} x
 * @param {number} y
 * @param {number} k
 * @return {number[][]}
 */
var reverseSubmatrix = function(grid, x, y, k) {
    
    for(let i = 0; i<Math.floor(k/2);i++){
        for(let j = 0; j<k; j++){
            let topRow = i + x;
            let bottomRow = x + k - 1 - i;
            let col = y + j;

            //swap
            let temp = grid[topRow][col];
            grid[topRow][col] = grid[bottomRow][col];
            grid[bottomRow][col] = temp;
        }
    }


    return grid;

};