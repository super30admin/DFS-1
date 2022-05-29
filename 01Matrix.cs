using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity :  O(MN)
    // Space Complexity :O(MN) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class _1Matrix
    {
        public int[][] UpdateMatrix(int[][] mat)
        {
            if (mat == null) return mat;
            int m = mat.Length;
            int n = mat[0].Length;
            int[,] dirs = new int[4, 2] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
            Queue<int[]> q = new Queue<int[]>();

            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (mat[i][j] == 0)
                    {
                        q.Enqueue(new int[] { i, j });
                    }
                    else
                    {
                        mat[i][j] = -1;
                    }
                }
            }

            while (q.Count != 0)
            {
                int[] current = q.Dequeue();
                for (int i = 0; i < dirs.GetLength(0); i++)
                {
                    int r = dirs[i, 0] + current[0];
                    int c = dirs[i, 1] + current[1];
                    if (r >= 0 && c >= 0 && r < m && c < n && mat[r][c] == -1)
                    {
                        q.Enqueue(new int[] { r, c });
                        mat[r][c] = mat[current[0]][current[1]] + 1;
                    }
                }
            }

            return mat;

        }
    }
}
