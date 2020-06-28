/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var updateMatrix = function(matrix) {
    let dirs = [[0,1],[0,-1],[-1,0],[1,0]];
    if(matrix == null || matrix.length == 0) return matrix;
    let q = [];
    let m = matrix.length;
    let n = matrix[0].length;
    for(i = 0; i<m;i++){
        for(j=0; j<n;j++){
            if(matrix[i][j] == 0){
                q.push([i,j]);
            } else {
                matrix[i][j] = -1;
            }
        }
    }
    let dist = 1;
    while(q.length != 0){
        let size = q.length;
        //level order traversal
        for(i = 0; i<size; i++){
            let curr = q.shift();
            for(let dir of dirs){
                let r = curr[0] + dir[0];
                let c= dir[1] + curr[1];
                if(r >=0 && r<m &&c>=0 && c<n && matrix[r][c] == -1){
                    matrix[r][c] = dist;
                    q.push([r,c]);
                }
            }
        }
        dist = dist +1;

    }
    return matrix;
    
    
};

//time complexity : O(mxn)
//space complexity : O(mxn)