// Time Complexity : O(m*n). m is the number of rows and n is the number of columns
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix==null || matrix.length==0) return matrix;
        
        Queue<int[]> q =new LinkedList();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else matrix[i][j]=-1;
            }
        }
        
        int distance=1;
        int dirs[][]=new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=0;j<size;j++){
                int[] current = q.poll();
            
            for(int i=0;i<dirs.length;i++ ){
                
                
                int[] dir = dirs[i];
                
                int r = current[0]+dir[0];
                int c = current[1]+dir[1];
                
                if(r>=0 && r<matrix.length&&c>=0 && c<matrix[0].length&&matrix[r][c]==-1){
                    q.add(new int[]{r,c});
                    matrix[r][c]=distance;
                }
            }
            }
            distance++;
        }
        
        return matrix;
        
    }
}
