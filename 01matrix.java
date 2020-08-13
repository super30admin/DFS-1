//Time complexity:O(m*n)
//Space Complexity:O(m*n)
/*Approach
-taking bfs approach,and taking all zeros as starting point for bfs ,because they are independent
-in place of 1s keeping -1 so that the value itself can be separated from distance from 0s
-then processing level by level and incrementing the distance of it by 1 of its previous
*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0) return matrix;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<matrix.length;++i)
        {
            for(int j=0;j<matrix[0].length;++j)
            {
                if(matrix[i][j]==0) q.add(new int[]{i,j});
                else matrix[i][j] = -1;
            }
        }
        int dist=1;
        while(!q.isEmpty())
        {   int size = q.size();
         for(int i=0;i<size;++i)
         {
             int[] current = q.poll();
            int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
            for(int[] dir : dirs)
            {
                int r = dir[0] + current[0];
                int c = dir[1] + current[1];
                if(r!=-1 && r!=matrix.length && c!=-1 && c!=matrix[0].length && matrix[r][c]==-1)
                {
                    matrix[r][c] = dist;
                    q.add(new int[]{r,c});
                }
            }
         }
         dist++;
            
        }
        return matrix;
    }
}