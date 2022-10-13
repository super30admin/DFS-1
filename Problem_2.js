// Problem2 (https://leetcode.com/problems/01-matrix/)
// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[][]} mat
 * @return {number[][]}
 */
var updateMatrix = function (mat) {
    if (mat === null || mat.length === 0)
        return [];

    let q = [];
    let dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    let rows = mat.length;
    let cols = mat[0].length;

    // Add all the 0's location in queue as it is independent
    // Mark the 1's as -1 to make sure they are not visited yet
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if (mat[i][j] === 0)
                q.push([i, j]);
            else
                mat[i][j] = -1;
        }
    }

    while (q.length > 0) {
        let node = q.shift();
        dirs.forEach(dir => {
            // For each direction if the cell is valid and it is -1 i.e not visited, set its value to  node location+1
            // Push it to queue
            let nr = node[0] + dir[0];
            let nc = node[1] + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && mat[nr][nc] === -1) {
                mat[nr][nc] = mat[node[0]][node[1]] + 1;
                q.push([nr, nc]);
            }
        })
    }
    return mat;
};