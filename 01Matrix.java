// Time Complexity : O(m*n) where m is number of rows and n is number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/01-matrix/)
// Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
// The distance between two cells sharing a common edge is 1.

// Example 1:
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]

// Example 2:
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
 
// Constraints:
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// There is at least one 0 in mat.

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // Edge case: return original matrix if empty
        if (mat == null || mat.length == 0){
            return mat;
        }
        int m = mat.length;
        int n = mat[0].length;

        // Directions for Up, Down, Left, Right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // U D L R
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add all 0s to queue and mark 1s as unvisited (-1)
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0){
                    q.add(new int[] {i, j}); // enqueue position of 0
                }
                else{
                    mat[i][j] = -1; // mark unvisited 1s
                }
            }
        }

        int level = 0; // Tracks distance from 0

        // Step 2: BFS traversal from all 0s simultaneously
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int[] curr = q.poll();

                for(int[] dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    // Only visit unvisited neighbors (-1)
                    if (nr >= 0 && nr < m && nc >= 0 && nc <n && mat[nr][nc] == -1){
                        mat[nr][nc] = level + 1; // Update distance
                        q.add(new int[] {nr, nc}); // Enqueue the neighbor
                    }
                }
            }
            level++; // Increment level after processing current layer
        }

        return mat;
    }
}