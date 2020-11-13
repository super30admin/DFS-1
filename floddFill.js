/**
// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 




* @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */

var floodFill = function(image, sr, sc, newColor) {
    if(image == null || image.length == 0) return image
    
      
    let ogColor = image[sr][sc];
      if(ogColor == newColor) return image
  
    dfs(image, sr, sc, newColor)
    return image
  
    function dfs(image, i, j, newColor){
        //base
      if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != ogColor) return 
        //logic
      let dirs = [[0,1],[0,-1],[-1,0],[1,0]];
      image[i][j] = newColor;
      for(let dir of dirs){
          let r = dir[0] + i
          let c = dir[1] + j
  
          dfs(image, r, c, newColor)
      }
   
    }
  };