import java.util.*;

class Solution {
    // BFS Solution
    // Time complexity is O(mn)
    // Space complexity is O(max(m,n))
    // This solution is submitted on leetcode with no errors
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Edge case
        int rowLen = image.length;
        int colLen = image[0].length;
        // Save the initial color
        int prevCol = image[sr][sc];
        if(image == null || rowLen== 0 || prevCol == newColor) return image;
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] arr = q.poll();
            image[arr[0]][arr[1]] = newColor;
            for(int [] dir: dirs){
                int r = arr[0] + dir[0];
                int c = arr[1] + dir[1];
                if(r>=0 && c>=0 && r<rowLen && c<colLen && image[r][c]==prevCol){
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
    }
}