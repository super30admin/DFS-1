/**LC-542
 * Time Complexity : O(MN) 
 * Space Complexity : O(MN) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
 1. Look for independent nodes. In this case, 0s are the independent nodes. Always start BFS from independent nodes
 2. Iterate over the whole matrix and convert all 1s to -1s
    3. insert all 0s into the queue(independent nodes)
 4. maintain a global count which contains distance
 5. For each level, increment the count variable

 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return matrix;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < matrix.length; i++){
            
            for(int j = 0; j < matrix[0].length; j++){
                
                if(matrix[i][j] == 0){
                    
                    q.add(new int[]{i, j});
                }
                else{
                    matrix[i][j] = -1;
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i <size ; i++){
                
                int[] curr = q.poll();
                for(int[] dir: dirs) {
                   int r = curr[0] + dir[0];
                   int c = curr[1] + dir[1];
                   if(r>= 0 && r<matrix.length && c>=0 && c < matrix[0].length && matrix[r][c] == -1){
                       q.add(new int[]{r, c});
                       matrix[r][c] = count;
                   }
                }
            
            }
            count++;
        }
        return matrix;
        
    }
}