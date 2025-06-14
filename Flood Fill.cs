/*
  Time complexity: O(m*n)
  Space complexity: O(m*n)

  Code ran successfully on Leetcode: Yes
  
*/

public class Solution {

    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        int[,] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int origColor = image[sr][sc];
        image[sr][sc] = color;
        if(color!=origColor)
            helper(image, sr, sc, origColor, color, dir);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int origColor, int color, int[,] dir)
    {
        
            for(int i=0;i<4;i++)
            {
                int item1 = sr+dir[i,0];
                int item2 = sc+dir[i,1];
                if(item1>=0 && item1<image.Length && item2>=0 && item2<image[0].Length && image[item1][item2]==origColor)
                {
                    image[item1][item2] = color;
                    helper(image, item1, item2, origColor, color, dir);
                }
            }
        
    }
}
