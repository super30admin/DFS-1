import java.util.LinkedList;
import java.util.List;

// Time Complexity : O(nm)
// Space Complexity :O(d)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge case
        if(image == null || image.length==0) return image;
        int oldColor = image[sr][sc];
        if(oldColor==newColor) return image;
        color(image,sr,sc,oldColor,newColor);

        return image;
    }
    private void color(int[][] image, int sr, int sc,int oldColor, int newColor)
    {
        if(image[sr][sc]==oldColor)
        {
            image[sr][sc] = newColor;
            for(int[] p:neighbour(image,sr,sc))
            {
                int a= p[0];
                int b = p[1];
               color(image,a,b,oldColor,newColor);
            }
        }
    }
    private List<int[]> neighbour(int[][] image , int sr, int sc)
    {
        List<int []> result = new LinkedList<>();
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir:dirs)
        {
            int R = sr+dir[0];
            int C = sc+dir[1];
            if(R>=0 && R < image.length && C >=0 && C <image[0].length)
            {
                result.add(new int[]{R,C});
            }
        }
        return result;
    }
}