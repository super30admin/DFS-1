package S30.DFS_1;

import java.util.LinkedList;
import java.util.Queue;

/*BFS Solution
Time Complexity : O(MxN) - touching every node to traverse entire matrix in worse case
Space Complexity : O(MxN) - expanding in all directions at each node, soon covers entire matrix in worse case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*DFS Solution
Time Complexity : Put: O(MxN) - touching every node to traverse entire matrix in worse case
Space Complexity : O(MxN) - all nodes in recursive stack in worse case
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class FloodFill {

    int R = 0;
    int C = 0;
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0},{1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        this.R = image.length;
        if(R == 0 || image == null) return image;
        this.C = image[0].length;
        int sourceColor = image[sr][sc];
        if(sourceColor == newColor) return image;
        image[sr][sc] = newColor;
        fill(image,sr,sc,newColor,sourceColor);
        return image;

    }

    private void fill(int[][] image, int sr, int sc, int newColor, int sourceColor){

        for(int[] dir : dirs){

            int r = sr + dir[0];
            int c = sc + dir[1];

            if(r >= 0 && c >= 0 && r < R && c < C && image[r][c] == sourceColor){
                image[r][c] = newColor;
                fill(image,r,c,newColor,sourceColor);
            }
        }

    }

    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor){
        this.R = image.length;
        if(R == 0 || image == null) return image;
        this.C = image[0].length;
        int sourceColor = image[sr][sc];
        if(sourceColor == newColor) return image;
        image[sr][sc] = newColor;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[]curr = queue.poll();
            for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r < 0 || c < 0 || r >= R || c >= C || image[r][c] != sourceColor) continue;
                image[r][c] = newColor;
                queue.offer(new int[]{r,c});
            }
        }
        return image;
    }


}
