// Problem1 (https://leetcode.com/problems/flood-fill/)
// BFS
// TC: O(m+n)
// SC: O(m+n)

// DFS
// TC: O(m+n)
// SC: O(m+n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


let dfs = (image, sr, sc, oldColor, color) => {

    if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] !== oldColor)
        return;
    // Logic
    image[sr][sc] = color;

    dfs(image, sr + 1, sc, oldColor, color);
    dfs(image, sr, sc + 1, oldColor, color);
    dfs(image, sr - 1, sc, oldColor, color);
    dfs(image, sr, sc - 1, oldColor, color);

}
/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} color
 * @return {number[][]}
 */
var floodFill = function (image, sr, sc, color) {

    if (image === null || image.length === 0)
        return [];
    if (image[sr][sc] === color)
        return image;

    let rows = image.length;
    let cols = image[0].length;
    let q = [[sr, sc]];
    let oldColor = image[sr][sc];
    let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    dfs(image, sr, sc, oldColor, color);

    // BFS
    // image[sr][sc] = color;
    // while(q.length>0){
    //     let node = q.shift();
    //     dirs.forEach(dir => {
    //         let nr = node[0]+dir[0];
    //         let nc = node[1]+dir[1];
    //         if(nr>=0 && nr<rows && nc>=0 && nc<cols && image[nr][nc]===oldColor){
    //             image[nr][nc] = color;
    //             q.push([nr,nc]);
    //         }
    //     })
    // }
    return image;
};