/**
 * time complexity O(m*n)
 * space complexity is O(m*n)
 * implemented using BFS
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {0,1}, {1,0}};
        
        int pt = sr*cols + sc;
        queue.add(pt);
        int originalColor = image[sr][sc];
        image[sr][sc] = newColor;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int currPt = queue.remove();
                seen.add(currPt);
                int i = currPt/cols;
                int j = currPt%cols;
                            
                for(int[] dir : dirs) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if(ii >= 0 && ii < rows && jj >= 0 && jj < cols && image[ii][jj] == originalColor) {
                        image[ii][jj] = newColor;
                        if(!seen.contains(ii*cols + jj))
                        queue.add(ii*cols + jj);
                    }
                }
            }
        }
        return image;
    }
}