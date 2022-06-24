// Time Complexity : O(M * N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Normally, In DP we use previous values to get op. Here In matrix, we can use 2 previous values at a time
// But our distance can be from any of the 4-directions
// so we have to do 2 Iterations :: 1) Up and Left 2) Bottom and Right

class Solution {
    public int[][] updateMatrix(int[][] mat) {
// Using DP
        int m = mat.length;
        int n = mat[0].length;
        // Value cannot be greater than m + n
        int INF = m + n + 1;


        // First Move Up and Left -> Get the Min Distance
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int up = INF, left = INF;

                // we don't care about 0
                if (mat[i][j] == 0) continue;

                if (i - 1 >= 0) up = mat[i - 1][j];
                if (j - 1 >= 0) left = mat[i][j - 1];

                mat[i][j] = Math.min(up, left) + 1;
            }
        }

        // Do it for right and bottom
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int down = INF, right = INF;

                if (mat[i][j] == 0) continue;

                if (i < m - 1) down = mat[i + 1][j];
                if (j < n - 1) right = mat[i][j + 1];

                mat[i][j] = Math.min(mat[i][j], Math.min(right, down) + 1);
            }
        }

        return mat;
    }
}
