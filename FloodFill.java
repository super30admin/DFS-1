// Time Complexity: O(mn)
// Space Complexity: O(mn)
// BFS Approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;
        int dirs[][] = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0} };
        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int curr[] = q.poll();

            for(int dir[]: dirs){
                int r = dir[0] + curr[0];
                int c = dir[1] + curr[1];

                if(r>=0 && c>=0 && r<m && c<n && image[r][c] == oldColor){
                    image[r][c] = color;
                    q.add(new int[]{r,c});
                }
            }
        }
        return image;
        
    }
}


// Time Complexity: O(mn)
// Space Complexity: O(mn)
// DFS Approach
class Solution {

    int dirs[][] ;
    int m;
    int n;
    int newColor;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc] == color) return image;
        dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0} };
        m = image.length;
        n = image[0].length;
        newColor = color;

        oldColor = image[sr][sc];
       
        image[sr][sc] = color;

        dfs(image,  sr, sc);
        return image;
        
    }

    private void dfs(int[][] image, int i, int j){

        image[i][j] = newColor;
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            if(r>= 0 && c>=0 && r<m && c<n && image[r][c] == oldColor){
                dfs(image, r, c);
            }
        }
    }
}