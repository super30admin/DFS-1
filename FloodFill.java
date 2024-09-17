//Approach 1 BFS

class Solution {

    // Time Complexity : 0(m*n)
// Space Complexity : 0(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I solved this question via a BFS approach. The reason for taking
    //BFS approach was because the change in one index of the matrix affected the others. I took a linked list to store the row
    //index and anothe LL to store the column index. Then I took a direction array to navigate in the 4 directions. I then
    //added the targer row and column to my queue and also change its color to the new color. Then, I extracted the index of
    //row and column and iterated over my direction array to check all 4 directions of the present element. If the index
    //were in the bound and if the current color was old color, then I changed the color to new color and added the row and
    //column index to my queue.

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        Queue <Integer> row = new LinkedList<>();
        Queue <Integer> column = new LinkedList<>();
        int color = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        int [][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        row.add(sr);
        column.add(sc);
        image[sr][sc] = newColor;

        while(!row.isEmpty()){
            int a = row.poll();
            int b = column.poll();
            for(int [] dir: direction){
                int r = dir[0] + a;
                int c = dir[1] + b;
                if(r >= 0 && c >= 0 && r < m && c < n && image[r][c] == color){

                    image[r][c] = newColor;
                    row.add(r);
                    column.add(c);
                }
            }
        }
        return image;

    }
}

//DFS approach

class Solution {
    int[][] direction;
    int color, m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor){
            return image;
        }
        m = image.length;
        n = image[0].length;
        direction = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        color = image[sr][sc];

        dfs( sr, sc, newColor, image);
        return image;

    }
    public void dfs( int sr, int sc, int newColor, int [][] image){
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        for(int[] dir: direction){
            int r = dir[0] + sr;
            int c = dir[1] + sc;
            dfs(r, c, newColor, image);
        }
    }
}