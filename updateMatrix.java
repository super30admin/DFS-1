// Time Complexity : O(m*n) m and n are rows and columns of grid
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        
        if(matrix==null || matrix.length==0) return matrix;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else if(matrix[i][j]==1) matrix[i][j]=-1;
            }
        
        int dist=1;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size!=0)
            {
                int[] cur = q.poll();
                for(int[] dir : dirs)
                {
                    int r = dir[0] + cur[0];
                    int c = dir[1] + cur[1];
                    if(r>=0 && c>=0 && r<matrix.length && c<matrix[0].length && matrix[r][c]==-1)
                    {
                        matrix[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
                size--;
            }
            dist++;
        }
        return matrix;
    }
}