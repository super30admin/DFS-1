/*
Time Complexity: O(n)
Space Complexity: O(1)
DFS Approach - Recursion : paint the starting pixel with the new color and all the qualifying neighboring pixels of the old color in each iteration
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;

        int color = image[sr][sc];
        dfs(image, sr, sc, color, newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int newColor){
        //Base Case
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || image[row][col] != color)
            return;

        image[row][col] = newColor;

        int[][] dirs = {{0,-1}, {0, 1}, {1, 0}, {-1, 0}};
        for(int[] dir: dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            dfs(image, r, c, color, newColor);
        }
    }

}

/*
Time Complexity: O(n)
Space Complexity: O(n)
BFS Approach : paint the starting pixel with the new color and all the qualifying neighboring pixels of the old color in each iteration
*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor)
            return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};

        int color = image[sr][sc];

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                image[cur[0]][cur[1]] = newColor;

                for(int[] dir: dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];

                    if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c] == color && !visited[r][c]){
                        q.add(new int[]{r,c});
                        visited[r][c] = true;
                    }
                }
            }
        }
        return image;
    }
} 