// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

import java.util.Arrays;

public class FloodFill {
    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
        int oldColor = image[sr][sc];

        dfs(image, sr, sc, color, oldColor, dir);

        return image;
    }
    static void dfs(int[][] image, int sr, int sc,int color, int oldColor, int[][] dir ) {

        image[sr][sc] = color;
        for(int[] d : dir) {
            int cr = d[0] + sr;
            int cc = d[1] + sc;
            if(cr >= 0  && cr < image.length && cc >=0 && cc < image[0].length && image[cr][cc] == oldColor) {
                dfs(image, cr, cc, color, oldColor, dir);
            }
        }
    }

    public static void main(String[] args) {
        int[][] images = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1, sc = 1;
        int color = 2;
        System.out.println("Images with old pixel:");
        for (int[] p : images) {
            System.out.println(Arrays.toString(p));
        }

        int[][] res = floodFill(images, sr, sc, color);
        System.out.println("Images with new pixel:");
        for (int[] p : res) {
            System.out.println(Arrays.toString(p));
        }


    }
}
