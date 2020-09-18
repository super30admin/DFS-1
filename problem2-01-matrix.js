//// Time Complexity : O(NxM) we have to visit each cell, NxM is the size of the input 2d matrix
//// Space Complexity : O(NxM) we may have a queue that is as long as all the cells (all but 1 cell is 0)
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// intuition

//// Your code here along with comments explaining your approach

// insert all 0's into queue as a start
// pop the first element, check all 4 directions where it can update a 1
// if it can't update any neighbors, do nothing
// if you can update, update the count for that cell AND push that updated location into the queue
// return the matrix which will contain the answers within each cell
var updateMatrix;

updateMatrix = function(matrix) {
  var directions, front, i, j, k, l, m, n, queue, ref, ref1;
  if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
    return matrix;
  }
  n = matrix.length;
  m = matrix[0].length;
  queue = [];
// Convert 1 -> infinity and 0 add to queue
  for (i = k = 0, ref = n; (0 <= ref ? k < ref : k > ref); i = 0 <= ref ? ++k : --k) {
    for (j = l = 0, ref1 = m; (0 <= ref1 ? l < ref1 : l > ref1); j = 0 <= ref1 ? ++l : --l) {
      if (matrix[i][j] === 0) {
        queue.push([i, j]);
      } else if (matrix[i][j] === 1) {
        matrix[i][j] = Number.MAX_SAFE_INTEGER;
      }
    }
  }
  directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
  while (queue.length !== 0) {
    front = queue.shift();
    i = front[0];
    j = front[1];
    directions.map(function(dir) {
      var c, r;
      r = i + dir[0];
      c = j + dir[1];
      if (r >= 0 && r < n && c >= 0 && c < m && (matrix[i][j] + 1 < matrix[r][c])) {
        matrix[r][c] = matrix[i][j] + 1;
        return queue.push([r, c]);
      }
    });
  }
  return matrix;
};

//# sourceMappingURL=problem2-01-matrix.js.map
