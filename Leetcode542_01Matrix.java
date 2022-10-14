/* */
//BFS approach
//1. scan the matrix, add coordinates of 0 to the queue and mark 1 as visited = -1
//2. while q not empty
//3. take size of the queue - poll the existing nodes and add their neighbors into the queue, only if they are -1.
//inside queue - assign size to the co-ordinaes of the neighbor to mark their distance from zero. 
//tc - O(V+E) = O(mn)+ O(mn) = 2O(m*n) = O(mn)
//sc-O(V+E) = O(mn) = O(m*n) = O(mn) - queue - at most will only hold m*n as we are not going to re-insert the visited neighbos. 
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0) return new int[][] {};
        
        
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0; i< m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                    q.add(new int[] {i,j});
                else
                   mat[i][j] = -1; 
            }
        }
        
        //BFS
        int dist =1;
        while(!q.isEmpty())
        {
            int size = q.size(); //this will help to distinguish levels
            
            for(int k = 0; k< size; k++)
            {
                int[] curr = q.poll();
                
                for(int[] dir : dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    
                    //boundary condition
                    if(nr >=0 && nr <m && nc >=0 && nc < n && mat[nr][nc] == -1)
                    {
                        mat[nr][nc] = dist;
                        q.add(new int[] {nr,nc});
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}



//BFS approach -2
//1. scan the matrix, add coordinates of 0 to the queue and mark 1 as visited = -1
//2. while q not empty
//3. No need of size variable. curr will have intitally 0, 
//so in our dirs array, we will just assign  - mat[curr[0]][curr[1]] +1 to the current neighbor. 
//so for every level, the curr will be updated and we will just assign +1 to it to their neighbors.
//TC and SC is same as approach -1  

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        if(mat == null || mat.length == 0) return new int[][] {};
        
        
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0; i< m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 0)
                    q.add(new int[] {i,j});
                else
                   mat[i][j] = -1; 
            }
        }
        
        //BFS
        
        while(!q.isEmpty())
        {
            
                int[] curr = q.poll();
                
                for(int[] dir : dirs)
                {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    
                    //boundary condition
                    if(nr >=0 && nr <m && nc >=0 && nc < n && mat[nr][nc] == -1)
                    {
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                        q.add(new int[] {nr,nc});
                    }
                }
            
        }
        return mat;
    }
}