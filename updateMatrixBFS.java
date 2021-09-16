// Time Complexity: We are traversing all the node constant in matrix => O(m*n)
// Space Complexity: Using a queue, it may contain all zeros => O(m*n)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approache here:
// Idea here is to perform BFS by first iterating through all cells in matrix
// adding all zeros to queue and making all 1s to -1 to avoid distance and cell value conflict
// perform BFS by polling elements from queue until queue becomes empty
// and assigning distance to cell value of each neighbour accessed by
// directions array and adding them to queue
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0) return mat;
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(mat[i][j]==1) {
                    mat[i][j] = -1;
                } else {
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir:dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && r<m && c>=0 && c<n && mat[r][c]==-1) {
                    mat[r][c]=mat[curr[0]][curr[1]]+1;
                    q.add(new int[] {r,c});
                }
            }
        }
        return mat;
    }
}