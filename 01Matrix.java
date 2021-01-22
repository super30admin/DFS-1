// Time Complexity : O(m*n) we will essentially go over each element in the m*n matrix
// Space Complexity : O(m*n) maximum number of elements in the queue at once can be m*n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS traversal
// Convert the 1's to -1, to keep a track of visited vs not visited.
// Fill the queue with 0's
// For each neighbor in the queue, update the matrix with the new depth for each level if value is -1


class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix == null || matrix.length == 0) return null;

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int []> q = new LinkedList();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j ++) {
                if(matrix[i][j] == 0) {
                   q.add(new int[]{i,j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] directionMatrix = new int[][]{{0,-1}, {0,1}, {1,0}, {-1,0}};

        while(!q.isEmpty()) {

            int[] curr = q.poll();
            int size = q.size();

            for(int[] direction : directionMatrix) {
                int r = curr[0] + direction[0];
                int c = curr[1] + direction[1];

                if(r >= 0 && r < m && c >=0 && c < n && matrix[r][c] == -1) {
                    q.add(new int[]{r,c});
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                }
            }

        }

        return matrix;
    }
}
