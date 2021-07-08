// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, worked it out to not use a "visited" array.

/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
// BFS
var updateMatrix = function(matrix) {
    if (matrix == null || matrix.length == 0) return matrix;
    
    let m = matrix.length,
        n = matrix[0].length,
        q = [],
        dist = 10000,
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][j] = dist;
                q.push([i, j]);
            }
        }
    }
    dist++;
    while (q.length > 0) {
        let size = q.length;
        for (let i = 0; i < size; i++) {
            let curr = q.shift();
            for (const dir of dirs) {
                let r = curr[0] + dir[0],
                    c = curr[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] < 10000) {
                    matrix[r][c] = dist;
                    q.push([r, c]);
                }
            }
        }
        dist++;
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            matrix[i][j] -= 10000;
        }
    }
    return matrix;
};
