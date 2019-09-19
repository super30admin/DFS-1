/*
Author: Akhilesh Borgaonkar
Problem: Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
    and a pixel value newColor, "flood fill" the image.
Approach: Used BFS approach to flood fill the given image grid. Color the input starting coordinates i.e. sr & sc and put them in queue, pop it from queue.
    Explore neighboring pixels of image grid, mark it with new color and put it in the queue if the new pixel
    is not equal to 0 and is not already colored. Finally, return the image grid.
Time Complexity: O(R*C) where R is number of rows and C is number of columns in the input image grid.
Space Complexity: Constant
Known Issue: Fails for following input,
    image = [[0,0,0],[0,0,0]] ; sr = 0 ; sc = 0 ; newcolor = 2
*/

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<int[]> pixels = new LinkedList<int[]>();
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        int image_xn = image.length;
        int image_yn = image[0].length;

        /*for(int[] in : image)
            if(!( (in[0]+in[1]+in[2]) > 0 ));*/

        pixels.add(new int[]{sr,sc});
        image[sr][sc] = newColor;

        if(pixels.isEmpty())
            return image;


        while(!pixels.isEmpty()){
            int[] currPixel = pixels.remove();
            for(int[] directions : dir){
                int x = currPixel[0] + directions[0];
                int y = currPixel[1] + directions[1];

                if(x<0 || y<0 || x>=image_xn || y>=image_yn || image[x][y]==newColor || image[x][y]==0)
                    continue;

                image[x][y] = newColor;
                pixels.add(new int[]{x,y});
            }
        }
        return image;
    }

}
