//https://leetcode.com/problems/01-matrix/
/*
Time: O(m*n) where m = rows and n = columns
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ZeroOneMatrix {
    // Why two different traversals -> Because say if you are moving in one
    // direction say top - bottom, the down and right cell aren't updated yet! there
    // might be better paths beneath them which aren't updated to them!

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int MAX = m + n; // The distance of cells is up to (M+N)

        // top to bottom and left to right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) // starting from (0,0) it doesn't have top and left, so check based on that
                {
                    int top = i - 1 >= 0 ? mat[i - 1][j] : MAX;
                    int left = j - 1 >= 0 ? mat[i][j - 1] : MAX;
                    mat[i][j] = Math.min(top, left) + 1;
                }
            }
        }

        // reverse
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) // starting from (m,n) it doesn't have bottom & right,so check based on
                                             // that
            {
                if (mat[i][j] != 0) {
                    int bottom = i + 1 < m ? mat[i + 1][j] : MAX;
                    int right = j + 1 < n ? mat[i][j + 1] : MAX;
                    mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1); // note
                }
            }
        }
        return mat;
    }

}
