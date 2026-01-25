// Given a 01 matrix, we need to find the distance of the nearest 0 for each cell. we use bfs to solve this problem, we start from all the 0 cells and explore their neighbors.
// If the neighbor is unvisited (value -1), we update its distance and add it to the queue. We continue this process until all cells are processed.
// Time complexity is O(m*n) where m is number of rows and n is number of columns
// Space complexity is O(m*n)
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val dirs = arrayOf(
            intArrayOf(-1,0),
            intArrayOf(1, 0),
            intArrayOf(0,-1),
            intArrayOf(0, 1)
        )
        val m = mat.size
        val n = mat[0].size

        val q = ArrayDeque<IntArray>()

        for(i in 0 until m) {
            for (j in 0 until n) {
                if (mat[i][j] == 0) {
                    q.addLast(intArrayOf(i,j))
                } else {
                    mat[i][j] *= -1
                }
            }
        }

        while(q.isNotEmpty()) {
            val curr = q.removeFirst()

            for(dir in dirs) {
                val r = curr[0] + dir[0]
                val c = curr[1] + dir[1]

                if (r >= 0 && c>= 0 && r < m && c < n && mat[r][c] == -1) {
                    q.addLast(intArrayOf(r, c))
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
                }
            }
        }

        return mat
    }
}