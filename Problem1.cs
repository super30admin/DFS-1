public class FloodFills
    {
        // Time Complexity : O(m * n) - have to traverse entire matrix
        // Space Complexity : O(m * n) - queue will have almost all elements from matrix in the worst case 
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        int[][] directions;

        public int[][] FloodFill(int[][] image, int sr, int sc, int color)
        {
            int m = image.Length;
            int n = image[0].Length;

            if (image == null || image.Length == 0) return image;
            int originalColor = image[sr][sc];

            if (image[sr][sc] == color)
                return image;

          
            directions = new int[][] {
                new int[] { 0, 1 }, //right
                new int[] { 0, -1 }, //left
                new int[] { 1, 0 }, //down
                new int[] { -1, 0 } //up
            };

            dfs(image, sr, sc, color, m, n, originalColor);

            return image;

        }

        public void dfs(int[][] image, int sr, int sc, int color, int m, int n, int originalColor)
        {
            //base case, 
            if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != originalColor)
            {
                return;
            }

            //logic
            image[sr][sc] = color;
            foreach (var dirs in directions)
            {
                int nr = sr + dirs[0];
                int nc = sc + dirs[1];
                dfs(image, nr, nc, color, m, n, originalColor);
            }

        }
    }
