// ## Problem1 (https://leetcode.com/problems/flood-fill/)

// DFS

let floodFill = function(image, sr, sc, newColor) {
    if (image[sr][sc] == newColor) return image; 
    let color = image[sr][sc]; 
    dfs(image,sr,sc,newColor, color); 
    return image; 
} 

function dfs(image, sr, sc, newColor, color) { 
    //base
    if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return; 
    //logic 
    image[sr][sc] = newColor; 
    let dirs = [[0,1], [1,0], [-1,0], [0,-1]]; 
    for(let dir of dirs) { 
        let r = sr + dir[0]; 
        let c = sc + dir[1]; 
        dfs(image, r , c, newColor, color); 
    } 
};

//BFS

let floodFill = function(image, sr, sc, newColor) {
    if(image[sr][sc] == newColor) return image;
    if(image == null || image.length == 0) return image;
    let q = [];
    let color = image[sr][sc];
    q.push([sr, sc]);
    image[sr][sc] = newColor;
    let dirs = [[0,1],[1,0], [-1,0],[0,-1]];
    while(q.length > 0) {
        let curr = q.shift();
        for(let dir of dirs){
            let i = dir[0] + curr[0];
            let j = dir[1] + curr[1];
            if(i>= 0 && i < image.length && j >=0 && j < image[0].length && image[i][j] == color) {
                q.push([i,j]);
                image[i][j] = newColor;
            }
        }
    }
    return image; 
};


// ## Problem2 (https://leetcode.com/problems/01-matrix/)

// DFS

var updateMatrix = function(matrix) {
    let m = matrix.length;
    // edge case
    if(matrix == null || m == 0) return matrix;
    let n= matrix[0].length;
    let result = [[]];
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            result[i][j] = dfs(matrix, result, i, j);
        }
    }
    return result;
    
    function dfs(matrix, result, i, j){
        // base case
        if(i < 0 || i >= m || j < 0 || j >= n) return 9999;
        if(matrix[i][j] == 0) return 0;
        if(i > 0 && matrix[i-1][j] == 0) return 1;
        if(j > 0 && matrix[i][j-1] == 0) return 1;
        if(i < m - 1 && matrix[i+1][j] == 0) return 1;
        if(j < n-1 && matrix[i][j+1] == 0) return 1;

        // Don't have any neighboring zero'
        let top, left, right, bottom;
        top = left = 9999; // Declare them as infinity
        if(i > 0 && result[i-1][j] != 0){
            top = result[i-1][j];
        }

        if(j > 0 && result[i][j-1] != 0){
            left = result[i][j-1];
        }

        bottom = dfs(matrix, result, i+1, j);
        right = dfs(matrix, result, i, j+1 );

        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;
    };
}

// BFS 

var updateMatrix = function(matrix) {
    let m = matrix.length;
    // edge case
    if(matrix == null || m == 0) return matrix;
    let n = matrix[0].length;
    let q = [];
    let dirs = [[0,1], [1,0], [-1,0], [0,-1]];
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(matrix[i][j] == 0){
            q.push([i, j]);
            } else {
            matrix[i][j] = Number.MAX_VALUE; 
            }
        }
    }
    while(q.length > 0) {
        let size = q.length;
        for(let k = 0; k < size; k++){
            let curr = q.shift();
            for(let dir of dirs){
                let r = dir[0] + curr[0];
                let c = dir[1] + curr[1];
                if(r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] > matrix[curr[0]][curr[1]] + 1 ){
                    q.push([r,c]);
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                }
            }
        }
    }
    return matrix;
}
