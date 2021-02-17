// Time Complexity : O(m*n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix==null || matrix.length==0) return matrix;
        Queue<int[]> q = new LinkedList();
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dis = new int[r][c];
        
        // find 0's
        int oranges = 0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                dis[i][j] = Integer.MAX_VALUE;
                if(matrix[i][j]==0) {
                    q.add(new int[]{i,j});
                    dis[i][j] = 0;
                }
            }
        }
        
        // Do BFS 
        int dirs[][] = {{0,1},{-0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            
            
            int size = q.size();
                            
            int[] idx = q.poll();
            for(int[] dir : dirs) {

                int newX = idx[0]+dir[0];
                int newY = idx[1]+dir[1];

                if(newX<0 || newX>=r || newY<0 || newY>=c || matrix[newX][newY]==0) continue;
                if(dis[newX][newY] > dis[idx[0]][idx[1]]+1) {
                    q.add(new int[]{newX,newY});
                    dis[newX][newY] = dis[idx[0]][idx[1]]+1;
                }
            }
        }
        return dis;
    }
}
