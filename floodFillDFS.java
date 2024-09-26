class Solution {
    int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int n=image[0].length;
        dfs(image,sr,sc);
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(image[i][j]==-1)
                    image[i][j]=newColor;
            }
        return image;
    }
    
    private void dfs(int[][] image,int sr,int sc)
    {
        int m=image.length;
        int n=image[0].length;
        int color=image[sr][sc];
        image[sr][sc]=-1;
        for(int[] dir:dirs)
        {
            int r=sr+dir[0];
            int c=sc+dir[1];
            if(r>=0 && r<m && c>=0 && c<n && image[r][c]==color)
            {
                dfs(image,r,c);
            }
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)