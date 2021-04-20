/**Leetcode Question 542 - 01 Matrix */
/**Algorithm - BFS
 * Push all the zero elements in the queue and mark the non zero elements as -1
 * Maintain a level starting at 1 and maintain the size of the queue
 * Everytime the size changes, the level is incremented.
 * Check if the neighbours are -1 and change it to the current level and add them to the queue
 */
/**TC - O(M*N)
 * SC - O(M*N)
 */
public class 01Matrix {
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return matrix;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int count =0;
            Queue<int[]> q = new LinkedList<>();
            
            for(int i =0; i< m; i++){
                for(int j =0; j<n; j++){
                    if(matrix[i][j] == 0){
                        q.add(new int[] {i,j});
                    }
                    else{
                        matrix[i][j] =-1;
                        count++;
                    }
                }
            }
            if(count == 0){
                return matrix;
            }
            int level =1;
            int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0},{-1,0}};
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0; i<size; i++){
                    int[] curr = q.poll();
                    for(int[] dir: directions){
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];
                        if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] == -1){
                            matrix[r][c] = level;
                            q.add(new int[] {r,c});
                        }
                    }
                }
                level++;
            }
            return matrix;
        }
    }
}

