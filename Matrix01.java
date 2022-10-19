// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach - 
/*
 * This is an optimized BFS approach where we begin by traversing over the matrix. If there is a 0, we add it to the
 * queue and if there is a 1, we make it -1 to mark it as visited.
 * Now, we perform BFS upon the added 0's, we maintain a size variable and at each level, we increase the 
 * distance by 1. In the end, we return the matrix.
 */

public class Matrix01 {
    if(matrix.length == 0 || matrix == null)
    {
        return matrix;
    }
    
    Queue<int []> q = new LinkedList<>();
    
    int m = matrix.length;
    int n = matrix[0].length;
    
    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    
    for (int i = 0; i < m;i++)
    {
        for(int j = 0;j<n;j++)
        {
            if(matrix[i][j] == 0)
            {
                q.add(new int[]{i,j});
            }
            else 
            {
                matrix[i][j] = -1;
            }
        }
    }
    
    int dist = 1;
    while(!q.isEmpty())
    {
        int size = q.size();
        for(int i = 0; i < size;i++)
        {
            int curr[] = q.poll();
            for(int dir[]:dirs)
            {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && matrix[nr][nc] == -1)
                {
                    matrix[nr][nc] = dist;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        dist++;
    }
    return matrix;
}
}
