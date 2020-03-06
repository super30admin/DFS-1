// Time Complexity : O(m*n)
// Space Complexity : O(n) : Queue datastructure space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Approach : BFS
// Create a result matrix and queue. Queue will be used to maintain the distance by processing elements level by level.
// Add all the coordinates in queue where value is zero in matrix. If value is non-zero, assign result element at that position with maximum possible value in this scenario(10000).
// Process elements in queue level by level and increment the distance at each level. Mark the non-zero element in matrix as zero and add in queue. At the same time make result value at that coordinate same as the distance.

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // edge case
        if(matrix == null || matrix.length == 0) return matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n]; // result matrix
        Queue<int[]> queue = new LinkedList<>(); 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j}); // adding all coordinates with 0 value in queue
                }
                else result[i][j] = 10000; // initialization for non-zero value positions in matrix
            }
        }
        int distance = 0;
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}}; // to check all 4 directions
        while(!queue.isEmpty()) {
            int size = queue.size(); // to iterate level by level
            distance += 1; // increase distance at each level
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] != 0) {
                        queue.offer(new int[]{x,y});
                        matrix[x][y] = 0; // a way to make sure that the same element is not added again
                        result[x][y] = distance;
                    }
                }
            }
        }
        return result;
    }
}

