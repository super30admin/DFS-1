/**
Problem: 01 Matrix
Did it run on LeetCode: Yes

Time Complexity : O(n), where n is the number of elements in the given matrix.
Space Complexity: O(m*n), where m is the number of rows, and n is the number of columns

Approach: BFS
1. We first place the elements which are 0 in our queue. We make any other elements as 1.
2. Then, while the queue is not empty, we keep adding the neighbors of the given cell to the queue. We keep track of the distance so far.
3. The way this works is, we keep incrementing the distance after every level, which gives us the distance of the nearest 0.
*/


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    q.add(new int[] {i , j});
                }
                else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
        int distance = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir : directions) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] == -1) {
                        matrix[r][c] = distance;
                        q.add(new int[] {r,c});
                    }
                }
            }
            distance++;
        }
        return matrix;
    }
}