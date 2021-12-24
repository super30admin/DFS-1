// TC - O(m*n)
// Space - O(m*n)
// Leetcode passed - Yes

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int [][] dirs;
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }

        dirs = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0,1}};
        color = image[sr][sc];
        floodFillDFS(image, sr, sc, newColor);
        return image;
    }

    public void floodFillDFS(int [][] image, int sr, int sc, int newColor) {
        // base case
        // if indices are beyond the extremes, or the element is not equal to color, then will simply return
        if(sr < 0 || sr >= image.length || sc <0 || sc>= image[0].length || image[sr][sc] != color) {
            return;
        }

        // logic
        // chaging it to new color
        image[sr][sc] = newColor;
        for(int [] dir: dirs) {
            // moving in all 4 directions and doing recursive call
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            floodFillDFS(image, nr, nc, newColor);
        }
    }

    // Time and space are same as DFS approach
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }

        int [][] dirs = new int[][]{{-1,0}, {1, 0}, {0, -1}, {0,1}};
        int color = image[sr][sc];

        Queue <Integer[]> q = new LinkedList <>();
        image[sr][sc] = newColor;
        q.add(new Integer[]{sr,sc}); // adding the first element into the queue

        Integer[] temp;
        int nr;
        int nc;
        while(!q.isEmpty()) {
            temp = q.poll();
            image[temp[0]][temp[1]] = newColor; // changing the color of the element
            for(int[] dir : dirs) {
                nr = temp[0] + dir[0];
                nc = temp[1] + dir[1];
                if(nr >=0 && nr < image.length && nc >=0 && nc < image[0].length && image[nr][nc] == color){
                    // checking that the element is a valid index and it's color is the original color
                    q.add(new Integer[]{nr, nc});
                }
            }
        }
        return image;
    }
}
