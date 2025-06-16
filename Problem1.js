// # DFS-1

// ## Problem1 (https://leetcode.com/problems/flood-fill/)

var floodFill = function(image, sr, sc, newColor) {
//     Time Complexity: O(m * n)
// Space Complexity: O(m * n)
    let OGcolor = image[sr][sc]
    if(image[sr][sc]== newColor) return image
    let queue = [[sr,sc]]
    while(queue.length){
        let [r,c] = queue.shift()
        //mark as visited
        if(r<0 || c<0 || r>image.length-1 || c>image[0].length-1 || image[r][c]!=OGcolor){
            continue
        }
            image[r][c] = newColor
            queue.push([r + 1, c]);
            queue.push([r - 1, c]);
            queue.push([r, c + 1]);
            queue.push([r, c - 1]);

    }
    return image
};
//DFS below
// var floodFill = function(image, sr, sc, color) {
//     let initialColor = image[sr][sc]
//     if (initialColor === color) return image;

//     function fill(row,col){
//         //this is my recursive function
//         if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) return
//         if(image[row][col]!== initialColor) return 

//         image[row][col] = color;

//         fill(row-1,col)
//         fill(row,col+1)
//         fill(row+1,col)
//         fill(row,col-1)

//     }
//     fill(sr,sc)
//     return image
// };