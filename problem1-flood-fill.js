//https://leetcode.com/problems/flood-fill/
//// Time Complexity : O(NxM)
//// Space Complexity : O(NxM)
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// none
//// Your code here along with comments explaining your approach
//recurse(matrix, i, j, oldColor, newColor, directions)
//  change oldcolor to new color
//  for each direction
//    if in bounds and color is oldcolor, recurse(...,new i, new j, ...)
var directions, floodFill;

directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];

floodFill = function(image, sr, sc, newColor) {
  var recurse;
  recurse = function(i, j, oldColor) {
    image[i][j] = newColor;
    return directions.forEach(function(dir) {
      var c, r;
      r = i + dir[0];
      c = j + dir[1];
      if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] === oldColor) {
        return recurse(r, c, oldColor);
      }
    });
  };
  if (image === null || image.length === 0 || image[0].length === 0 || image[sr][sc] === newColor) {
    return image;
  }
  recurse(sr, sc, image[sr][sc]);
  return image;
};

//# sourceMappingURL=problem1-flood-fill.js.map
