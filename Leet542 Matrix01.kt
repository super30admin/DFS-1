import java.util.*

// Time Complexity : O (m * n)
// Space Complexity : O (m * n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : line 26 and 42
class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val ROWS = mat.size
        val COLS = mat[0].size
        val dir = arrayOf(
            -1 to 0, //up
            0 to 1, //right
            1 to 0, //down
            0 to -1 //left
        )

        val q = LinkedList<IntArray>()

        fun findFirstZeros(){
            for(r in 0 until ROWS){
                for(c in 0 until COLS){
                    if(mat[r][c] == 0){
                        q.add(intArrayOf(r, c))
                    }else{
                        mat[r][c] = -1
                    }
                }
            }
        }

        findFirstZeros()

        var distance = 1
        while(q.isNotEmpty()){
            val qSize= q.size
            repeat(qSize){
                val zero = q.remove()
                for((dr, dc) in dir){
                    val r = zero[0]+dr
                    val c = zero[1] + dc
                    if(r in 0 until ROWS && c in 0 until COLS && mat[r][c] == -1){
                        mat[r][c] = distance
                        //now these neighbours whose distance we found will become point for others
                        q.add(intArrayOf(r, c))
                    }
                }
            }
            distance++
        }
        return mat
    }
}