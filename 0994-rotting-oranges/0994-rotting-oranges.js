/**
 * @param {number[][]} grid
 * @return {number}
 */

const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];


var orangesRotting = function(grid) {
    let result = 0;
    let queue = [];
    for(let i = 0; i < grid.length; i++){
        for(let j = 0; j<grid[0].length; j++){
            if(grid[i][j] === 2){
               // bfs(grid, i, j);
                queue.push([i, j]);
            }
        }
    }

    let res = bfs(grid, queue, result);
    return checkFresh(grid) === 0 ? res : -1;
};

function bfs(grid, queue, result){

    // let queue = [];
    // queue.push(grid[x][y]);

    while(queue.length > 0){

        let levelSize = queue.length;
        var flag = false;

        for(let i = 0; i<levelSize; i++){
            let rottenOrange = queue.shift()
            let x = rottenOrange[0];
            let y = rottenOrange[1];
            for(let dir of directions){
                let newX = x + dir[0];
                let newY = y + dir[1];
                if(newX < grid.length && newY < grid[0].length && newX >= 0 && newY >= 0 && grid[newX][newY] === 1){
                    grid[newX][newY] = 2;
                    flag = true;
                    queue.push([newX, newY]);
                }
            }
        }
        
        if(flag === true){
            result +=1;
        }


    }
    return result;
}


function checkFresh(grid){

    for(let i = 0; i<grid.length; i++){
        for(let j = 0; j<grid[0].length; j++){
            if(grid[i][j] === 1){
                return -1;
            }
        }
    }

    return 0;

}