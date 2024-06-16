/*
    LC - https://leetcode.com/problems/01-matrix/description/
    TC - O(m * n)
    SC - O(m * n)
        if everything is zero then this is worst case
    Approach - Using BFS
        Use the queue data structure to store the matrix with zero
        set all the value except zero to -1
        check if queue is empty, and poll it
        find all four directions and check if it is -1 and calculate the level
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) {
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
        for(int i = 0; i<m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j});
                } 
                else {
                    mat[i][j] = -1;
                }
            }
        }
        int lvl = 0;
        while(!q.isEmpty()) {
            // int size = q.size();
            // for(int i = 0; i< size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                        q.add(new int[] {nr, nc});
                    }
                }
            // }
            lvl++;
        }
        return mat;
    }
}