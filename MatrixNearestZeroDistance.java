package DFS1;

import java.util.LinkedList;
import java.util.Queue;

/*you are given a 2d array .this matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:
Input:
0 0 0
0 1 0
0 0 0

Output:
0 0 0
0 1 0
0 0 0

Example 2:
Input:
0 0 0
0 1 0
1 1 1

Output:
0 0 0
0 1 0
1 2 1
Source Link: https://leetcode.com/problems/01-matrix/

-------------------------------------------------------------------------------------------------------
Time complexity :  O(MN)
space complexity: O(MN)
Did this code run successfully in leetcode : yes
problems faces : no*/

public class MatrixNearestZeroDistance {

 public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length ==0) return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int []> q = new LinkedList<>();
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++ )
            {
                
                if(mat[i][j] == 0 )
                {
                   q.add(new int[]{i,j});
                   
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
       // int dist = 0;
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            
            int size = q.size();
           // dist++;
            
            for(int i=0;i<size;i++)
            {
                int[] curr = q.poll();
                
                
                for(int[] d : dirs)
                {
                    int r = curr[0]+d[0];
                    int c = curr[1]+d[1];
                    
                    if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == -1)
                    {
                        //mat[r][c] = dist ;
                        mat[r][c] = mat[curr[0]][curr[1]]+1; ;
                        q.add(new int[]{r,c});
                    }
                     
                }
                
            }
            
        }
        
        return mat;
        
    }
}
