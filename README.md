# DFS-1

## Problem1 (https://leetcode.com/problems/flood-fill/)
class Solution {
    int[][] dirs=  {{1,0},{-1,0},{0,1},{0,-1}};
    int m,n,color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // null case
        if(image==null || image.length==0 || image[sr][sc]==newColor) return image;
        color= image[sr][sc];
         m =image.length;
         n= image[0].length;
        dfs(image,sr,sc,newColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor)
    {
       
        //base
        if(sr<0 || sc<0 || sr==m || sc ==n || image[sr][sc]!=color ) return;
        //logic
        image[sr][sc]=newColor;
        for(int[] dir:dirs)
        {
            int r =sr+dir[0];
            int c =sc+dir[1];
            dfs(image,r,c,newColor);
        }
        
    }
}
Time Complexity:O(m*n)
Space Complexity:O(1)


## Problem2 (https://leetcode.com/problems/01-matrix/)
class Solution {
    int m,n;
    int[][] dirs={{1,0},{-1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        m=mat.length;
        n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j]=-1;
            }
        }
        int dist=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
            int[] curr= q.poll();
            for(int[] dir: dirs)
            {
                int r= dir[0]+curr[0];
                int c= dir[1]+curr[1];
                if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1)
                {
                    mat[r][c]=dist;
                    q.add(new int[]{r,c});
                }
            }
            
            }
            dist++;
           
        }
        return mat;
        
    }
}
Time Complexity:O(m*n)
Space Complexity:O(m*n)
