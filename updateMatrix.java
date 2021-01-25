// Time Complexity : o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int []> q = new LinkedList<>();
        if(matrix == null) return matrix;
        int m = matrix.length; int n = matrix[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i = 0; i < m; i++)
        {
            for(int j=0; j<n ; j++)
            {
                if(matrix[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else
                    matrix[i][j] = -1;
            }
        }
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[]  dir: dirs)
            {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] == -1)
                {
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1;
                    q.add(new int[]{r,c});
                }
            }
        }
        return matrix;
    }
}