/**
 * @param {number[][]} mat
 * @return {number[][]}
 * 
 * https://leetcode.com/problems/01-matrix/
 * 
Intuition:

For this problem, i am using BFS approach to solve it. 

Because BFS explores level by level, the first time we visit a cell we are guaranteed to have found the shortest distance to a 0.
 
I am initially collecting all the 0's on the queue and 1's to -1, so will be able to differentiate between the visited cells that got 1's and pre existing 1s.

We are iterating over the zeros and traversing all 4 directions to find -1 and if i find any i am setting those to currentValue plus 1.

If it is either 0 or already visited cell then we are skipping those and returning mat at the end of the solution.

T.C: O(m*n)
S.C: O(m*n)

 */
var zeroOneMatrix = function (mat) {
    let m = mat.length;
    let n = mat[0].length;
    const queue = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (mat[i][j] === 0) {
                queue.push([i, j]);
            } else {
                mat[i][j] = -1;
            }
        }
    }
    const directions = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    while (queue.length) {
        const length = queue.length;
        const [row, col] = queue.shift();
        for (let [i, j] of directions) {
            const [newRow, newCol] = [row + i, col + j];
            if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && mat[newRow][newCol] === -1) {
                queue.push([newRow, newCol]);
                mat[newRow][newCol] = mat[row][col] + 1;
            }
        }
    }
    return mat;
};