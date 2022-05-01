using System;
using System.Collections.Generic;
using System.Text;

namespace BinaryTree
{
    public class FloodFill
    {
        /*
         * T.C: O(M*N)  Since traversing through all the image
         * S.C: O(M*N)  worst case queue will have all the coordinate
         */
        public int[][] CheckFloodFill(int[][] image, int sr, int sc, int newColor)
        {


            if (image == null || image.Length == 0 || image[sr][sc] == newColor)
            {
                return image;
            }

            int[,] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }; //R,D,U,L


            Queue<int> row = new Queue<int>();
            Queue<int> col = new Queue<int>();
            int color = image[sr][sc];
            int m = image.Length;
            int n = image[0].Length;

            row.Enqueue(sr);
            col.Enqueue(sc);
            image[sr][sc] = newColor;

            while (row.Count != 0)
            {
                int r = row.Dequeue();
                int c = col.Dequeue();
                for (int i = 0; i < dir.GetLength(0); i++)
                {
                    int nr = dir[i, 0] + r;
                    int nc = dir[i, 1] + c;
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == color)
                    {
                        image[nr][nc] = newColor;
                        row.Enqueue(nr);
                        col.Enqueue(nc);
                    }

                }
            }

            return image;

        }


        //DFS
        /*
         * T.C: O(m*n) traversing through all the elements of image
         * S.C: O(m*n) worst case all entries will be there in stack
         */
        int[,] dir;
        int Color, m, n;
        public int[][] GetFloodFill1(int[][] image, int sr, int sc, int newColor)
        {
            if (image == null || image.Length == 0 || image[sr][sc] == newColor)
                return image;

            Color = image[sr][sc];
            m = image.Length;
            n = image[0].Length;
            dir = new[,] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
            dfs(image, sr, sc, newColor);

            return image;
        }

        private void dfs(int[][] image, int r, int c, int newColor)
        {


            if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != Color)
                return;

            image[r][c] = newColor;

            for (int i = 0; i < dir.GetLength(0); i++)
            {
                int nr = dir[i, 0] + r;
                int nc = dir[i, 1] + c;
                dfs(image, nr, nc, newColor);
            }


        }
    }
}
