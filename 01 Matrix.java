/*
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix is None or len(matrix) == 0:
            return matrix
        
        rows = len(matrix)
        cols = len(matrix[0])
        q = collections.deque()
        
        for i in range(rows):
            for j in range(cols):
                if matrix[i][j] == 0:
                    q.append((i,j))
                else:
                    matrix[i][j] = -1
        
        dist = 1
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        while len(q) > 0:
            size = len(q)
            
            for i in range(size):
                curRow, curCol = q.popleft()
                for r,c in dirs:
                    newRow = r + curRow
                    newCol = c + curCol
                    
                    if newRow >= 0 and newRow < rows and newCol >= 0 and newCol < cols and matrix[newRow][newCol] == -1:
                        matrix[newRow][newCol] = dist
                        q.append((newRow, newCol))
            
            dist += 1
            
            
        return matrix
*/


// Time Complexity : O(rows * cols)
// Space Complexity : O(rows * cols)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: added all the 0's to the queue and then started with bfs and updated 
// the distance to the nearest one by keeping track of levels


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;
        
        int rows = matrix.length, cols = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i=0; i< rows; i++){
            for (int j=0; j<cols; j++){
                if (matrix[i][j] == 0)
                    q.add(new int[] {i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        int dist = 1;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i<size; i++){
                int[] cur = q.poll();
                
                for (int[] d:dirs){
                    int newRow = cur[0] + d[0];
                    int newCol = cur[1] + d[1];
                    
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] == -1){
                        matrix[newRow][newCol] = dist;
                        q.add(new int[] {newRow, newCol});
                    }
                }
            }
            dist++;
        }
        
        return matrix;
    }
}