/**
 * An image is represented by a 2-D array of integers, each integer representing
 * the pixel value of the image (from 0 to 65535).
 * 
 * Given a coordinate (sr, sc) representing the starting pixel (row and column)
 * of the flood fill, and a pixel value newColor, "flood fill" the image.
 * 
 * To perform a "flood fill", consider the starting pixel, plus any pixels
 * connected 4-directionally to the starting pixel of the same color as the
 * starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color as the starting pixel), and so on. Replace the
 * color of all of the aforementioned pixels with the newColor.
 * 
 * At the end, return the modified image.
 * 
 * Idea:
 * Use breadth first search on the given location, start off by marking the positions to be updated as -1,
 * Then in breadth first manner, try visiting the 4 neighbouts and continue until termination.
 * 
 * Space Complexity: O(mn)
 * Time Complexity: O(mn)
 * 
 * Leetcode Result: 
 * TODO The below code contains bugs
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int[] x = new int[] { -1, 0, 1, 0 };
        int[] y = new int[] { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair current = q.remove();
            for (int dx : x) {
                for (int dy : y) {
                    if (current.x + dx >= 0 && current.x + dx < m && current.y + dy >= 0 && current.y + dy < n
                            && image[current.x + dx][current.y + dy] == image[current.x][current.y]) {
                        q.add(new Pair(current.x + dx, current.y + dy));
                    }
                }
            }
            image[current.x][current.y] = -1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == -1) {
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}