// Time Complexity : O(n*m)
// Space Complexity : O(n*m) for worst case where all all 0s except 1 cell which has to be pushed initially into queue.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return new int[][]{};
        Queue<int[]> res=new LinkedList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
                else if(matrix[i][j]==0){
                    res.add(new int[]{i,j});
                }
            }
        }
        int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};
        while(!res.isEmpty()){
            int[] front = res.poll();
            
            for(int[] dir:directions){
                int r=front[0]+dir[0];
                int c=front[1]+dir[1];
                
                if(r>=0&&r<matrix.length&&c>=0&&c<matrix[0].length&&matrix[front[0]][front[1]]+1<matrix[r][c]){
                    
                        matrix[r][c]=matrix[front[0]][front[1]]+1;
                        res.add(new int[]{r,c});
                    
                }
            }
        }
        return matrix;
        
    }
}