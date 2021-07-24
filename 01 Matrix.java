class Solution {
    public int[][] updateMatrix(int[][] mat)
    {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0 ; i<mat.length ; i++)
        {
            for(int j=0 ; j<mat[0].length ; j++)
            {
                if(mat[i][j] == 0) q.add(new int[]{i,j});
                else mat[i][j] = -1;
            }
        }

        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int dist = 1;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0 ; i<size ; i++)
            {
                int[] curr = q.poll();

                for(int[] dir:dirs)
                {
                    int r = dir[0]+curr[0];
                    int c = dir[1]+curr[1];

                    if(r>=0 && r<mat.length && c>=0 && c<mat[0].length && mat[r][c] == -1)
                    {
                        mat[r][c] = dist;
                        q.add(new int[]{r,c});
                    }
                }
            }

            ++dist;
        }

        return mat;
    }
}
