// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We do the BFS traversal and add all the 0's to the queue and change the 1's to -1 marking it as unvisited
We identify the neighbours of the popped queue element and update its distance 
Once the level processing is complete we increase the distance by 1
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(mat[i][j] == 0) {
=                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size;i++) {
                int[] cur = q.poll();

                for(int[] dir: dirs) {
                    int r = dir[0] + cur[0];
                    int c = dir[1] + cur[1];
                    if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1) {
                        mat[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }
            dist++;
            
        }
        return mat;
        
    }
}
