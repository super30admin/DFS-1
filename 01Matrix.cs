// TimeComplexity = O(mn)
//space complexity = O(mn)
// Approach - Take all 0's in queue. Check neighbours in BFS manner with dir array. 
// Update each neighbour with value of curr cell +1
public class Solution
{
    public int[][] UpdateMatrix(int[][] mat)
    {
        int[][] dir = new int[][] { [0, 1], [0, -1], [1, 0], [-1, 0] };
        int m = mat.Length; ;
        int n = mat[0].Length;
        Queue<int[]> bfs = new Queue<int[]>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    bfs.Enqueue([i, j]);
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        //int distance = 1;
        while (bfs.Count() > 0)
        {
            int size = bfs.Count();
            for (int i = 0; i < size; i++)
            {
                int[] curr = bfs.Dequeue();
                foreach (var d in dir)
                {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1)
                    {
                        bfs.Enqueue([nr, nc]);
                        //mat[nr][nc] = distance;
                        mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                    }
                }
            }
            //distance++;
        }
        return mat;
    }

}