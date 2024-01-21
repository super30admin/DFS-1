
//TC = O(m*n)
//SC = O(m*n)
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
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
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int[] cur = q.poll();
                for(int[] dir: dirs)
                {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if(nr >= 0 && nc >=0 && nr < m && nc < n)
                    {
                        if(matrix[nr][nc] == -1)
                        {
                            matrix[nr][nc] = matrix[cur[0]][cur[1]] + 1;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        return matrix;
    }
}