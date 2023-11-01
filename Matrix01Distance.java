// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Matrix01Distance {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0)
                    queue.add(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }
        int totalDisatance = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int[] cell = queue.poll();
                for(int[] dir : dirs)
                {
                    int nr = cell[0] + dir[0];
                    int nc = cell[1] + dir[1];

                    if(nr < 0 || nr >= mat.length || nc < 0 || nc >= mat[0].length)
                        continue;
                    if(mat[nr][nc] == -1)
                    {
                        queue.add(new int[]{nr, nc});
                        mat[nr][nc] = totalDisatance;
                    }
                }
            }
            totalDisatance++;
        }
        return mat;
    }
}
