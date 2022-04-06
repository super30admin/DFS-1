// Time Complexity : O(mxn) dimensions of the matrix
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    //BFS
    public int[][] updateMatrix(int[][] mat) {

        if(mat == null)
            return mat;

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList();

        int[][] directions = new int[][] {
            {-1,0},{1,0},{0,-1},{0,1}
        };

        //traverse the matrix and put 0s (independent nodes) in queue. Also, make all 1s into -1s to distinguish between original val being 1 and it's distance from nearest 0 being 1
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                    q.add(new int[] {i,j});
                else
                    mat[i][j] = -1;
            }
        }

        int distance = 1; //level value

        while(!q.isEmpty())
        {
            int len = q.size();

            for(int i=0; i<len; i++)
            {
                int[] node = q.remove();

                for(int[] d : directions)
                {
                    int r = d[0] + node[0];
                    int c = d[1] + node[1];

                    if(r>=0 && c>=0 && r<m && c<n)
                    {
                        if(mat[r][c] == -1)
                        {
                            q.add(new int[]{r,c});
                            mat[r][c] = distance;
                        }
                    }
                }
            }

            //next level
            distance++;
        }

        return mat;

    }
}
