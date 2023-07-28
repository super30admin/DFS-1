package DFS;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

public class Matrix01UsingBFS {

    public int[][] updateMatrix(int[][] mat) {

        if(mat == null || mat.length == 0) return mat;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            for(int[] dir:dirs)
            {
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r>=0 && c>=0 && r<m && c<n && mat[r][c] == -1)
                {
                    q.add(new int[]{r,c});
                    mat[r][c] = mat[curr[0]][curr[1]] + 1;
                }
            }
        }

        return mat;


    }
}
