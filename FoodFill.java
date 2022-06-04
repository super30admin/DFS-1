// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.LinkedList;
import java.util.Queue;

public class FoodFill {
    private int[][] dirs = new int[][] {{-1, 0}, {0,-1}, {0,1}, {1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        int m = image.length;
        int n = image[0].length;
        int element = image[sr][sc];
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        row.add(sr);
        column.add(sc);
        while(!row.isEmpty()){
            int r = row.poll();
            int c = column.poll();
            if(element == image[r][c]){
                image[r][c] = -1;
                for(int[] dir : dirs){
                    int i = dir[0] + r;
                    int j = dir[1] + c;
                    if(i < 0 || i >= m || j < 0 || j >= n) continue;
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int i =0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(image[i][j] == -1) image[i][j] = newColor;
            }
        }
        return image;
    }
    
}