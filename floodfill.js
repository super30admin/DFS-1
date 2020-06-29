/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
let color;
var floodFill = function(image, sr, sc, newColor) {
    if(image == null || image[sr][sc] == newColor) return image;
    color = image[sr][sc];
    dfs(image,sr,sc,newColor);
    return image;
};

var dfs = function(image, sr, sc, newColor){
    //base
    if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc] != color) return ;
    //logic
    var dirs = [[0,1],[0,-1],[-1,0],[1,0]];
    image[sr][sc] = newColor;
    for(let dir of dirs){
        let r = parseInt(dir[0]) + parseInt(sr);
        let c = parseInt(dir[1]) + parseInt(sc);
        dfs(image,r,c,newColor);
    }
}

//time comlexity : O(mxn) : m -no of rows, n - no of columns
//space complexity : O(mxn) - worst time complexity