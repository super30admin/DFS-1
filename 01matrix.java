//Time complexity : O(mn)
//Space Complexity : O(mn)
//Approach : BFS 
//iDEA : perform bfs on all the 0. processes all independent nodes together.

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int dirs[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++)
            {
                if(mat[i][j] == 0)
                    q.add(new int[] {i,j});
                else if(mat[i][j] == 1)
                    mat[i][j] = -1;
            }
        }
        
        int dist = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int s = 0 ; s < size; s++)
            {
                int[] current = q.poll();
                for(int [] dire : dirs)
                {
                    int nr = current[0] + dire[0];
                    int nc = current[1] + dire[1];
                    
                    if(nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1)
                    {
                            q.add(new int[]{nr,nc});
                            mat[nr][nc] = dist;
                    }
                }
            
            }
            dist++;
        }
        
        return mat;
    }
}
