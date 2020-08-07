/** 
Problem: Flood fill
Did it run on LeetCode: Yes

Time Complexity : O(n), where n is the number of pixels in the given image matrix
Space Complexity: O(m*n), where m is the number of rows, and n is the number of columns

Approach 1 : DFS
1. We solve this using DFS. We go to the neighbors of the given cell first.
2. We then recursively traverse(DFS) until all the neighbors of that particular neighboring cell have changed their color.
3. This is repeated for all the neighbors of the given cell. In the end, we'd have filled the image with the given color.

Approach 2 : BFS
1. In BFS, we first add the given cell to the queue and change its color.
2. Next, we change the colors of the neighboring cells and add them to the queue.
3. This is done iteratively until all the neighboring cells have changed their color.
*/

//DFS
class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) {
            return image;
        }
        color = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int newColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color || image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] dir : directions) {
            int r = sr + dir[0];
            int c = sc + dir[1];
        dfs(image, r, c, newColor);
        }
    }
}

//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        int color = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        image[sr][sc] = newColor;
        q.add(new int[]{sr,sc});
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir : directions) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
            if(r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color ) {
                image[r][c] = newColor;
                q.add(new int[]{r,c});
            }
        }
    }
    return image;
    }  
}
        