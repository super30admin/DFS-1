// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * We are using BFS here going level by level
 * 
 * first we find all the 0s and push there coordinates in the queue
 * while doing this convert all the non 0 to -1
 * 
 * we initialise the dict as 1
 * start the bfs
 * and using the dirs array to find the over element to be added that are equal to -1
 * and change there value to the cur value to dict
 * 
 * after the for loop ends increase the distance counter 
 * 
 * after every node is processed return the mat with the updated distance
 * 
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dict = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur[] = q.poll();
                for (int[] dir : dirs) {
                    int cr = cur[0] + dir[0];
                    int cc = cur[1] + dir[1];
                    if (cr >= 0 && cr < m && cc >= 0 && cc < n && mat[cr][cc] == -1) {
                        q.add(new int[] { cr, cc });
                        mat[cr][cc] = dict;
                    }
                }
            }
            dict++;
        }
        return mat;
    }
}