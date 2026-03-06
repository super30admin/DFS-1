// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to identify zeroes in the input matrix and add them to queue to perform the BFS traversal to find
the neighbours(1's) and update them with their respective distances by taking snapshot of the queue at every
traversal.However, we need to distinguish the actual cell value of 1s' and distance of 1, so we initially
make all the cell values having 1 as -1 and then update them with their respective distances.
 */
class Solution {
    int[][] dirs;
    int m, n;
    public int[][] updateMatrix(int[][] mat) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                }
                else
                    mat[i][j] = -1;
            }
        }

        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && mat[x][y] == -1) {
                        mat[x][y] = dist;
                        q.add(new int[] {x, y});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}