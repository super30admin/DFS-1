using System;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity :  O(MN)
    // Space Complexity :O(MN) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class FloodFill
    {
        int[,] dirs;
        int color;
        public int[][] FloodFill_DFS(int[][] image, int sr, int sc, int newColor)
        {
            if (image == null || image[sr][sc] == newColor) return image;
            dirs = new int[4, 2] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
            int m = image.Length;
            int n = image[0].Length;
            color = image[sr][sc];
            dfs(image, sr, sc, m, n, newColor);
            return image;
        }

        private void dfs(int[][] image, int r, int c, int m, int n, int newColor)
        {
            //base
            if (r < 0 || c < 0 || r == m || c == n || image[r][c] != color)
                return;
            //logic
            image[r][c] = newColor;
            for(int i = 0; i < dirs.GetLength(0); ++i)
                {
                    int nr = r + dirs[i, 0];
                    int nc = c + dirs[i, 1];
                    dfs(image, nr, nc, m, n, newColor);
                }
            
        }



        public int[][] FloodFill_BFS(int[][] image, int sr, int sc, int newColor)
        {
            if (image == null || image[sr][sc] == newColor) return image;
            int[,] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
            int m = image.Length;
            int n = image[0].Length;
            int color = image[sr][sc];
            Queue<int> rq = new Queue<int>();
            Queue<int> cq = new Queue<int>();
            rq.Enqueue(sr);
            cq.Enqueue(sc);
            image[sr][sc] = newColor;
            while (rq.Count != 0)
            {
                int r = rq.Dequeue();
                int c = cq.Dequeue();
                for (int i = 0; i < dirs.GetLength(0); ++i)
                {

                    int nr = r + dirs[i, 0];
                    int nc = c + dirs[i, 1];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color)
                    {
                        image[nr][nc] = newColor;
                        rq.Enqueue(nr);
                        cq.Enqueue(nc);
                    }

                }
            }

            return image;
        }
    }
}
