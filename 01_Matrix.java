// Time Complexity :O(mxn)
// Space Complexity :O(mxn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    int min=0;
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return matrix;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=Integer.MAX_VALUE;
                }else{
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()){
            int size = q.size();
            int[] root = q.poll();
            int root_i = root[0];
            int root_j = root[1];
    
            for(int[] dir:dirs){
                int r = dir[0]+root_i;
                int c= dir[1]+root_j;
                
                if(r>=0 && r<m && c>=0 && c<n && (matrix[root_i][root_j]+1<matrix[r][c])){
                    q.add(new int[]{r,c});
                    
                    matrix[r][c]=matrix[root_i][root_j]+1;
                }
            }
        }
        
        return matrix;
        
    }
}