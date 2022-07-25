// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// BFS
class NearestZero {
    public int[][] updateMatrix(int[][] mat) {
        //base case
        if(mat == null || mat.length == 0) return mat;

        int[][] dirs = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        //if the value is 0, add it to queue or if it is 1, change the value to -1
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }


        while(!q.isEmpty()) {
            int[] rowCol = q.poll();
            int row = rowCol[0];
            int col = rowCol[1];

            for(int[] dir: dirs) {
                //get neighbouring row and col
                int newRow =  row + dir[0];
                int newCol =  col + dir[1];

                //check the boundaries and check if the value is -1
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && mat[newRow][newCol] == -1) {

                    //change the value to (parent value + 1)
                    mat[newRow][newCol] = mat[row][col] + 1;

                    //add new row and col to queue
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}