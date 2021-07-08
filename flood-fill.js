// Time Complexity : O(M*N) for BFS and DFS
// Space Complexity : O(M*N) for BFS and DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
// DFS (iterative)
// var floodFill = function(image, sr, sc, newColor) {
//     if (image == null || image.length == 0) return image;
//     if (image[sr][sc] == newColor) return image;
    
//     let original = image[sr][sc],
//         stack = [[sr, sc]],
//         dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]],
//         m = image.length,
//         n = image[0].length;
//     image[sr][sc] = newColor;
    
//     while (stack.length) {
//         let curr = stack.pop();
//         for (const dir of dirs) {
//             let dr = dir[0] + curr[0],
//                 dc = dir[1] + curr[1];
            
//             if (dr >= 0 && dr < m && dc >= 0 && dc < n && image[dr][dc] == original) {
//                 image[dr][dc] = newColor;
//                 stack.push([dr, dc]);
//             } 
//         }
//     }
//     return image;
// };

// DFS (recursive)
let dirs, m, n, original;
var floodFill = function(image, sr, sc, newColor) {
    if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;
    
    original = image[sr][sc];
    dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]],
    m = image.length,
    n = image[0].length;
    dfs(image, sr, sc, newColor);
    return image;
};

var dfs = function(image, r, c, newColor) {
    // Base Case
    if (image[r][c] != original) return;
    
    // Logic
    image[r][c] = newColor;
    for (const dir of dirs) {
        let dr = dir[0] + r;
        let dc = dir[1] + c;
        if (dr >= 0 && dr < m && dc >= 0 && dc < n) dfs(image, dr, dc, newColor);
    }
};

// BFS
// var floodFill = function(image, sr, sc, newColor) {
//     if (image == null || image.length == 0 || image[sr][sc] == newColor) return image;
    
//     let original = image[sr][sc],
//         queue = [[sr, sc]],
//         dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]],
//         m = image.length,
//         n = image[0].length;;
//     image[sr][sc] = newColor;
    
//     while (queue.length) {
//         let curr = queue.shift();
        
//         for (const dir of dirs) {
//             let dr = dir[0] + curr[0],
//                 dc = dir[1] + curr[1];
            
//             if (dr >= 0 && dr < m && dc >= 0 && dc < n && image[dr][dc] == original) {
//                 image[dr][dc] = newColor;
//                 queue.push([dr, dc]);
//             }
//         }
//     }
//     return image;
// };
