/*
Time Complexity : O(MxN), M is the rows and N is the cols in the matrix
Space Complexity : O(MxN) for the queue
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :

BFS: We can add the sr and sc source to the queue if the existing color doesnt match the new color. We can process the
cell in the queue one by one, add all of its children if their color matches the color of the parent. After adding the
children to the queue, we will change the color of the child to the new color and finally return the image.
*/

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[][] floodFillBfs(int[][] image, int sr, int sc, int color) {
        Queue<Integer> queue = new LinkedList<>();
        int parentColor = image[sr][sc];
        queue.add(sr);
        queue.add(sc);
        // store its prev color and give the parent the new color
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int currRow = queue.poll();
            int currCol = queue.poll();
            for(int[] dir : directions){
                // find all children that have the same color as parent and add them to the queue.
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if(isInBounds(newRow, newCol, image) && image[newRow][newCol] == parentColor){
                    queue.add(newRow);
                    queue.add(newCol);
                    // Update the child color as soon as they are added to the queue to not visit them again.
                    image[newRow][newCol] = color;
                }
            }
        }
        return image;
    }

    private boolean isInBounds(int row, int col, int[][] image) {
        if(row < 0 || row == image.length) return false;
        if(col < 0 || col == image[0].length) return false;
        return true;
    }

    /*============= DFS ============
    Time Complexity : O(MXN), M is the rows and N is the cols in the matrix
    Space Complexity : O(MXN), all M*N nodes can be in the recursion stack
    DFS:
    If the parent cell color doesn't match the new color, start dfs on them. Find any children of it, that has the same
    color as them and call dfs on it. Once all the children and children's children are processed return the image.
    */

    public int[][] floodFillDfs(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        floodFillRecursion(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void floodFillRecursion(int[][] image, int sr, int sc, int parentColor, int color) {
        int rows = image.length;
        int cols = image[0].length;
        if(sr < 0 || sr == rows) return;
        if(sc < 0 || sc == cols) return;
        // check if the child color do not match the parent color, do not proceed
        if(image[sr][sc] != parentColor) return;

        image[sr][sc] = color;
        for (int[] dir: directions){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            floodFillRecursion(image, nr, nc, parentColor, color);
        }
    }
}
