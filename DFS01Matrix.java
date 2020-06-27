/**
 * Time complexity : O(M*N) where M and N are dimensions of the matrix
 * Space complexity : O(M*N) in the worst case, every element of matrix is already 0 and the queue will be full of 0s
 * Here we will preprocess the matrix, we'll add the 0 elements in the queue and others will be assigned as -1(unexplored)
 */


import java.util.Queue;
import java.util.LinkedList;

public class DFS01Matrix {
    public int[][] updateMatrix(int[][] matrix) {

        Queue<int []> q = new LinkedList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j ++)
            {
                if(matrix [i][j] == 0)
                {
                    q.add(new int[]{i,j});
                }
                else
                {
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int dist = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ;i < size; i ++)
            {
                int[] curr = q.poll();
                for(int[] d : dirs)
                {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if(r>=0 && r<m && c>=0 && c<n && matrix[r][c] == -1)
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