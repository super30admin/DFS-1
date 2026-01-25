// In this problen, we need to change the color of certain area in the image. we use bfs to solve this problem. 
// We start from the given pixel and explore all its 4 directionally connected pixels that have the same color as the starting pixel.
// We change their color to the new color and continue this process until all connected pixels are processed. 
// Time complexity is O(N) where N is the number of pixels in the image
// Space complexity is O(N)

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )

        val m = image.size
        val n = image[0].size
        val oldColor = image[sr][sc]
        if(oldColor == color) return image
        val q : ArrayDeque<IntArray> = ArrayDeque()

        

        q.addLast(intArrayOf(sr,sc)) 
        image[sr][sc] = color

        while(q.isNotEmpty()) {
            val curr = q.removeFirst()
            for(dir in dirs) {
                val r = curr[0] + dir[0]
                val c = curr[1] + dir[1]

                if(r >= 0 && c>= 0 && r < m && c < n && image[r][c] == oldColor) {
                    image[r][c] = color
                    q.addLast(intArrayOf(r,c))
                }
            }
        }
        return image
    }
}