// Time Complexity :O(n*m)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//We are starting from zero and doing the BFS to update the distance 
//from one
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return matrix;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    queue.add(new int[]{i,j});
                }else if(matrix[i][j]==1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()){
            int[] front = queue.poll();
            
            for(int[] dir:dirs){
                int i = dir[0]+front[0];
                int j= dir[1] + front[1];
                
                if(i>=0&&i<n&&j>=0&&j<m&&(matrix[front[0]][front[1]]+1)<matrix[i][j] && matrix[i][j]!=0 ){
                    matrix[i][j]=matrix[front[0]][front[1]]+1;
                    queue.add(new int[]{i,j});
                }
            }
        }
        return matrix;
        
    }
}
