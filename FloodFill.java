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
 * Runtime: 1 ms, faster than 86.20% of Java online submissions for Flood Fill.
 * Memory Usage: 45.9 MB, less than 44.74% of Java online submissions for Flood Fill.
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null) return image;
        int m = image.length;
        if(m == 0) return image;
        int n = image[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        
        int srcColor = image[sr][sc];
        if(srcColor == newColor) return image;
        while(!q.isEmpty()) {
            Pair current = q.remove();
            image[current.x][current.y] = newColor;
            for(int i = 0; i < 4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];
                
                if(x >= 0 && x < m && y >= 0 && y < n && image[x][y] == srcColor) {
                    q.add(new Pair(x, y));
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