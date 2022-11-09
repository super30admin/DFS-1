package s30.DFS1;

import java.util.LinkedList;
import java.util.Queue;


public class FloodFill {


    private int srcColor;
    private int destColor;
    private int[][] directions = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };


    //DFS
    // Time Complexity: O(mn) traversing through all the elements
    // Space Complexity: O(mn) At worst case we'll have m*n recursive calls
    public void floodFillRec(int[][] image, int i, int j) {
          if(i <0 || i >= image.length || j <0 || j >= image[0].length || image[i][j] != srcColor) return;

          if(image[i][j] == srcColor) image[i][j] = destColor;

          floodFillRec(image, i+1, j);
          floodFillRec(image, i, j+1);
          floodFillRec(image, i-1, j);
          floodFillRec(image, i, j-1);
    }

    //BFS
    // Time Complexity : O(mn)
    // Space Complexity: O(d) diagonal of the matrix d = min(m,n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        srcColor = image[sr][sc];
        destColor = color;

        if(image[sr][sc] == color) return image;

        Queue<Pair> fill = new LinkedList();
        fill.add(new Pair(sr,sc));

        while(!fill.isEmpty()){

            Pair pair = fill.poll();

            image[pair.i][pair.j] = color;

            //add adjacent edges with same color
            for(int[] d: directions){
                int tempI = pair.i + d[0];
                int tempJ = pair.j + d[1];

                if(tempI >=0
                        && tempI < m
                        && tempJ >=0
                        && tempJ < n
                        && image[tempI][tempJ] == srcColor){
                    fill.add(new Pair(tempI, tempJ));
                }
            }

        }

        return image;

    }


    class Pair {
        int i;
        int j;

        Pair(int i, int j){
            this.i =i;
            this.j= j;
        }
    }


    public static void main(String[] args) {

    }
}
