// Time Complexity : BFS (O(mxn)), DFS (O(m^2 x n^2))
// Space Complexity : BFS (O(mxn), DFS(O(m^2 x n^2)))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Base case, if the given cell is already filled with new colour, return image as it is


// Your code here along with comments explaining your approach
/*
BFS: while queue is not empty, keep on adding the elements that are of old colour that are in the 4 directions and while polling, change the colour to a new colour.
DFS: Run DFS on the source and again run on the elements that are in the 4 directions, base case for recursion would be if the color of the element is not ol coolour.
 */

public class floodFill {
    int oldColor;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        //DFS
        if(image[sr][sc] == newColor) return image;

        dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

        int m = image.length;
        int n = image[0].length;

        dfs(image, m, n, sr, sc, newColor);
        return image;


        //BFS
        /*
        if(image[sr][sc] == newColor) return image;

        int[][] dirs = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};

        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{sr, sc});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            image[curr[0]][curr[1]] = newColor;
            for(int[] dir : dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r < m && c < n && r >= 0 && c >= 0 && image[r][c] == oldColor){
                    pq.add(new int[]{r,c});
                }
            }
        }

        return image;
        */
    }

    private void dfs(int[][] image, int m, int n, int x, int y, int newColor){
        //base
        if(image[x][y] != oldColor) return;

        image[x][y]=newColor;
        for(int[] dir : dirs){
            int r = dir[0] + x;
            int c = dir[1] + y;

            if(r < m && c < n && r >= 0 && c >= 0 && image[r][c] == oldColor){
                dfs(image, m, n, r, c, newColor);
            }
        }

    }
}
