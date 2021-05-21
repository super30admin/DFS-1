class Solution {
    //Time O(m*n)
    //Space O(m*n)
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0)
        {
            return mat;
        }
        Queue<int[]> Q = new LinkedList<>();
        for(int i = 0 ; i<mat.length ; i++)
        {
            for(int j=0 ; j< mat[0].length ; j++)
            {
                if(mat[i][j] == 0)
                {
                    Q.add(new int[] {i,j});
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!Q.isEmpty())
        {
                int[] curr = Q.poll();
                for(int[] dir : dirs)
                {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && mat[r][c] == -1)
                    {
                        Q.add(new int[] {r,c});
                        mat[r][c] = mat[curr[0]][curr[1]] + 1;
                    }
                }
        }
        return mat;
    }
}