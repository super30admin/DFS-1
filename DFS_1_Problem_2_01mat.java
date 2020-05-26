//Time complexity : O(m*n) we need to find distance for all the elements
//Space complexity : O(m * n) in the worst case, every element of matrix is already 0 and the queue will be full of 0s
//Runs successfully on leetcode
//No Problem

//Here we will preprocess the matrix, we'll add the 0 elements in the queue and others will be assigned as -1(unexplored)
//We we will be using bfs, so the distance will be the closest for each the elements



import java.util.LinkedList;
import java.util.Queue;

public class DFS_1_Problem_2_01mat {
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
