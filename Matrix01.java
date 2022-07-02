/*
This program uses a BFS approach to solving the problem. We start by taking all the 0s, and then calculating the distance 
to the all nearest 1s from the 0s. Using this calculated distance, we successively calculate distances to farther 1s, till
we have found all the distances for all the 1s.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0)
            return mat;
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        
        //Adding all the 0s in the queue
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                    q.add(new int[]{i,j});
                
                //We set all the 1s to -1 initially, so that we can overwrite distances more conveniently in the result
                else
                    mat[i][j] = -1;
            }
        }
        
        int dist = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                int[] curr = q.poll();
                
                for(int dir[]: dirs)
                {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1)
                    {   //Whenever we set distance of a 1, we add it to the queue.
                        mat[nr][nc] = dist + 1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }    
            //We increment distance as we traverse further 
            dist++;
        }
        
        return mat;
    }
}