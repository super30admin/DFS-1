// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class 01MatrixSolution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        //Trversing the matrix adding 0's to the queue and marking 1's as -1
        //so that later in the code we can check for -1 and replace it with distance.
        for(int row = 0; row < rows; row += 1) {
            for(int col = 0; col < cols; col += 1) {
                if(mat[row][col] == 0) {
                    q.add(new int[] {row, col});
                }
                if(mat[row][col] == 1) {
                    mat[row][col] = -1;
                }
            }
        }
        //Directions array to perform BFS
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int distance = 1;
        //Starting BFS in level wise traversal.
        //At each level incrementing the distance count.
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i += 1) {
                int[] curr = q.poll();
                for(int[] direction : directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && mat[newRow][newCol] == -1) {
                        mat[newRow][newCol] = distance;
                        q.add(new int[] {newRow, newCol});
                    }
                }
            }
            distance += 1;
        }
        return mat;
    }
}