public class Solution {
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)
    public int[][] UpdateMatrix(int[][] mat) {
        
            if (mat == null || mat.Length == 0)
            {
                return mat;
            }
            int m = mat.Length, n = mat[0].Length;
            int[][] dirs = new int[4][] { new int[2] { 0, 1 }, new int[2] { 1, 0 }, new int[2] { 0, -1 }, new int[2] { -1, 0 } };
            Queue<int> r = new Queue<int>();
            Queue<int> c = new Queue<int>();

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (mat[i][j] == 0)
                    {
                        r.Enqueue(i);
                        c.Enqueue(j);
                    }
                    else
                    {
                        mat[i][j] = -1;
                    }
                }
            }
            int lvl = 1;
            while (r.Count != 0)
            {
                int size = r.Count;
                for (int i = 0; i < size; i++)
                {
                    int row = r.Dequeue();
                    int col = c.Dequeue();
                    foreach (int[] dir in dirs)
                    {
                        int nr = row + dir[0];
                        int nc = col + dir[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1)
                        {
                            r.Enqueue(nr);
                            c.Enqueue(nc);
                            mat[nr][nc] = lvl;
                            //mat[nr][nc] = mat[row][col] + 1; to avoid lvl
                        }
                    }
                }
                lvl++;
            }
            return mat;
    }
}