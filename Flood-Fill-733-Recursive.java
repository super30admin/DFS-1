class Solution {
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)  
    int m=0;
    int n=0;
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    int main_color;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null || image.length==0 || image[sr][sc]==color)
        {
            return image;
        }
        main_color = image[sr][sc];
        // image[sr][sc] = color;
        m = image.length;
        n = image[0].length;
        dfs(image, sr,sc,color);   
       return image;  
    }

    private void dfs(int[][] image, int row, int col, int color)
        {
            if(row<0 || col<0 || row>=m || col>=n || image[row][col]!=main_color)
            {
                return;
            }

            image[row][col] = color;
            for (int []dir: dirs)
            {
                int nr = row+dir[0];
                int nc = col+dir[1];
                dfs(image, nr,nc, color);
            }
        }
}
