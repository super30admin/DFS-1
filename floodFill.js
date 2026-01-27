/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}

Intuition:
we start at the given pixel (sr, sc) and first remember its original color. 
Then, we check all four neighboring pixels—up, down, left, right.
If a neighbor has the same original color and hasn’t been changed yet, we change its color to the new one and keep doing the same thing from that neighbor. 
Basically, we’re spreading the new color to all connected pixels that had the original color, and we stop whenever we hit a pixel that’s different, already changed, or out of bounds. 

T.C: O(n),
S.C: O(n)
 */
var floodFill = function (image, sr, sc, color) {
    let originalColor = image[sr][sc];
    const m = image.length;
    const n = image[0].length;
    const directions = [[0, 1], [1, 0], [-1, 0], [0, -1]];
    const dfs = (row, col) => {
        // base case
        if (row < 0 || col < 0 || row === m || col === n ||
            image[row][col] !== originalColor || image[row][col] === color) return;

        // action
        image[row][col] = color;
        // recursion
        for (let [i, j] of directions) {
            const newRow = row + i;
            const newCol = col + j;
            dfs(newRow, newCol);
        }

    }
    dfs(sr, sc);
    return image;
};