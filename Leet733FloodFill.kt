// Time Complexity : O (m * n)
// Space Complexity : O (m * n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : forgot to add original color check the first time

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val ROWS = image.size
        val COLS = image[0].size
        // ------------------right, left, top, bottom
        val dirs = arrayOf(
            0 to 1, //up
            1 to 0, //right
            0 to -1, //down
            -1 to 0 // left
        )

        fun doDFS(r:Int, c:Int, originalColor:Int, color:Int){

            if(r < 0 || r >= ROWS || c < 0 || c >= COLS
                || image[r][c] == color || image[r][c] != originalColor){
                return
            }

            image[r][c] = color

            for((dr, dc) in dirs){
                doDFS(r + dr, c + dc, originalColor, color)
            }
        }

        if(image[sr][sc] == color){
            return image
        }else{
            val originalColor = image[sr][sc]
            doDFS(sr, sc, originalColor, color)
        }
        return image
    }
}