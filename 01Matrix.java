// Time Complexity : O(mn) m = no of rows, n = no of cols 
// Space Complexity : O(mn) m = no of rows, n = no of cols 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: 
// Main idea is that we can add elements with 0 to a queue and make other elements as -1 in the matrix.
// We can maintain a parameter for each level and increment it once the next levels elements(elements which are -1) are traversed and distances are updated.

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return matrix;
        int dist = 1;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else matrix[i][j]=-1;
            }
        }
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        while(!q.isEmpty()) {
           int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                for(int[] dir:dirs) {
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] == -1) {
                        matrix[r][c]=dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}