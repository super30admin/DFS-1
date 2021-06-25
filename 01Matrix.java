// Time Complexity : O(N*M) 
// Space Complexity : O(N*M) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Find all the 0 values and add them in the queue.
2. Assign all the 1s in the matrix to -1 
3. The 0's are the equivalent of level 1 in the graph.
4. Do BFS on the zeros to go to the next level and so on and replacing the value in the matrix
*/


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int  m = mat.length;
        int  n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int level = 1;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0)
                    q.add(new int[]{i, j});
                if(mat[i][j] == 1)
                    mat[i][j] = -1;
            }
        }
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0;i<len;i++) {
                int[] curr = q.poll();
                for(int dir[] : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    if( row>=0 && row<m && col>=0 && col<n && mat[row][col] == -1) {
                        q.add(new int[]{row, col});
                        mat[row][col] = level;
                    }
                }
            }
            level++;
        }
        return mat;
    }
}
