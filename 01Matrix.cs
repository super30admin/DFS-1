using System;
using System.Collections.Generic;
using System.Text;

namespace DFS_And_BFS
{
    public class _01Matrix
    {
        /*
         * T.C: O(m*n) since we are traversing all elements of matrix
         * S.C: O(m*m) 
         */
        public int[][] UpdateMatrix(int[][] mat)
        {

            if (mat == null || mat.Length == 0)
                return mat;

            Queue<int[]> queue = new Queue<int[]>();

            for (int i = 0; i < mat.Length; i++)
            {
                for (int j = 0; j < mat[0].Length; j++)
                {
                    if (mat[i][j] == 0)
                    {
                        queue.Enqueue(new int[] { i, j });
                    }
                    else
                    {
                        mat[i][j] = -1;
                    }
                }
            }

            int m = mat.Length;
            int n = mat[0].Length;
            int dist = 1;
            int[,] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }; //R,D,U,L

            while (queue.Count != 0)
            {
                int size = queue.Count;
                for (int j = 0; j < size; j++)
                {
                    int[] curr = queue.Dequeue();
                    for (int i = 0; i < dir.GetLength(0); i++)
                    {
                        int nr = dir[i, 0] + curr[0];
                        int nc = dir[i, 1] + curr[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1)
                        {
                            mat[nr][nc] = dist;
                            queue.Enqueue(new int[] { nr, nc });
                        }
                    }
                }
                dist++;

            }

            return mat;

        }
    }
}
