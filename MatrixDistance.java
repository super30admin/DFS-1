import java.util.LinkedList;
import java.util.List;
// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //edge case
        if(matrix == null || matrix.length==0) return matrix;
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dist = new int[R][C];
        Queue<int[]> q = new LinkedList<>();
         for(int i = 0 ; i <R;i++)
        {
            //first pass
            for(int j = 0;j<C;j++)
            {
               if(matrix[i][j]==0)
               {
                   dist[i][j]=0;
                   q.add(new int[]{i,j});
                   
               }
                else
                {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            
        }
        while(!q.isEmpty())
        {
            
            int size = q.size();
            for(int i = 0 ; i < size;i++)
            {
                int[] root = q.poll();
                int root_i=root[0];
                int root_j=root[1];
                for(int[] dirs: neighbour(matrix,root_i,root_j))
                {
                    int r = dirs[0];
                    int c = dirs[1];
                    if(matrix[r][c]==1 && dist[r][c]>dist[root_i][root_j])
                    {
                        dist[r][c] = dist[root_i][root_j]+1;
                        q.add(new int[]{r,c});
                    }
                }
            }
        }
     
        
    return dist; 
    }
private List<int[]> neighbour(int[][] matrix , int sr, int sc)
    {
        List<int []> result = new LinkedList<>();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs)
        {
            int R = sr+dir[0];
            int C = sc+dir[1];
            if(R>=0 && R < matrix.length && C >=0 && C <matrix[0].length)
            {
                result.add(new int[]{R,C});
            }
        }
        return result;
    }

}class MatrixDistance {

}