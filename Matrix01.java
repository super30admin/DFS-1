// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// BFS
// Initially set the cell to INF if it is not 0
// if the new distance >= current distance, do not explore again
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return matrix;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i, j});
                }else if(matrix[i][j]==1) {
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }  
        }
        
        int[][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};    
        while(!q.isEmpty()){
            int [] front = q.remove();    
            int i= front[0];
            int j= front[1];
            
            for(int[] dir : directions){
                int x = i + dir[0];
                int y = j + dir[1];   
                if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || matrix[x][y] <= matrix[i][j] +1)
                    continue;
                q.add(new int[]{x,y});
                matrix[x][y] = matrix[i][j] +1;  
            }
        }
        return matrix;
    }
}