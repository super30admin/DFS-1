// Time Complexity : 0(N)
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func updateMatrix(_ mat: [[Int]]) -> [[Int]] {
        var mat = mat
        if mat == nil || mat.count == 0 || mat[0].count == 0 {
            return mat
        }
       var queue = [[Int]]()
        var rows = mat.count
        var cols = mat[0].count
       var level = 0
       for row in 0..<rows {
           for col in 0..<cols {
               if mat[row][col] == 0 {
                   queue.append([row,col])
               }
           }
       }
        // BFS
        while !queue.isEmpty {
            var size = queue.count
            level += 1
            for i in 0..<size {
                var cell = queue.removeFirst()
                var row = cell[0]
                var col = cell[1]
                if row - 1 >= 0 && mat[row-1][col] == 1  {
                    queue.append([row-1,col])
                    mat[row-1][col] = level + 1
                }
                if row + 1 < rows && mat[row+1][col] == 1  {
                    queue.append([row+1,col])
                    mat[row+1][col] = level + 1
                }
                if col - 1 >= 0 && mat[row][col-1] == 1  {
                    queue.append([row,col-1])
                    mat[row][col-1] = level + 1
                }
                if col + 1 < cols && mat[row][col+1] == 1  {
                    queue.append([row,col+1])
                    mat[row][col+1] = level + 1

                }
            }
        }
        for i in 0..<rows {
            for j in 0..<cols {
                if mat[i][j] > 1 {
                    mat[i][j] = mat[i][j] - 1
                }
            }
        }
        return mat
    }