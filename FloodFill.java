// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //edge
        if(image == null || image.length == 0 || image[sr][sc] == newColor) return image;

        int m = image.length;
        int n = image[0].length;
        int orig = image[sr][sc];

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{sr,sc});

        image[sr][sc] = newColor;

        int [][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        //normal BFS
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[]dir : dirs){
                    //adjacent node coordinates
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    //if spot is in bounds and if same color
                    if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == orig){
                        //set to new color, add to queue
                        image[r][c] = newColor;
                        q.add(new int[]{r,c});
                    }
                }

            }
        }
        return image;
    }
}