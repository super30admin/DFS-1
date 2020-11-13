// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 




var updateMatrix = function(matrix) {
    let q = []
    let m = matrix.length, n = matrix[0].length;
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(matrix[i][j] == 0){
                q.push(matrix[i][j]);
            }
            else {
                matrix[i][j] = -1
            }
        }
    }

    //let dist = 1
    let dirs = [[0,1], [0,-1], [-1,0], [1,0]];
    while(q.length > 0){
        let curr = q.shift();
        for(let dir of dirs){
            let r = dir[0] + curr[0]
            let c = dir[1] + curr[1]
            if(r >= 0 && c >= 0 && r < m && c < n && matrix[r][c] == -1){
                matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                q.push([r,c])
            }
        }
    }
    return matrix
};