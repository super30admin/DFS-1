Time complexity : O(M*N)
Space complexity : O(M*N)
Using BFS
/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var updateMatrix = function(matrix) {
    const q = [];
    for(let row = 0; row < matrix.length; row += 1){
        for(let col = 0; col < matrix[0].length; col += 1){
            if(matrix[row][col] > 0) {
               matrix[row][col] = Infinity
            } else {
                q.push([row, col, 0])
            }
        }
    }
    
    let dir = [[-1,0],[1,0],[0,-1],[0,1]];

    while(q.length) {
        const [row,col,dist] = q.shift();
        if(matrix[row][col] > dist) {
            matrix[row][col] = dist
        }
        
        dir.forEach(([r,c]) => {
            if(row+r >= 0 && row+r < matrix.length && col+c >= 0 && col+c < matrix[0].length) {
                if(matrix[row+r][col+c] === Infinity) q.push([row+r,col+c,dist+1])
            }
        })
    }
    
    return matrix
};