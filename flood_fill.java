public class flood_fill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color)

                return image;

            int color1 = image[sr][sc];

            dfs(image,sr,sc,color, color1);

            return image;

        }

        private void dfs(int[][] image, int sr, int sc, int color, int color1)

        { // base case

            if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color1)

                return;

            //logic

            image[sr][sc] = color;

            int [][] dirs = new int[][]

                    {{0,1}, {1,0}, {-1,0}, {0,-1}};

            for(int[] dir : dirs)
            {
                int r = sr + dir[0];
                int c = sc + dir[1];
                dfs(image, r , c, color, color1);
            }
        }
    }
}
