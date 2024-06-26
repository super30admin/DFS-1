//Problem 1
// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    int n,m;
    int dirs[][];
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image==null|| image.length==0|| image[sr][sc]==color) return image;
        n=image.length;
        m=image[0].length;
        dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};// U D L R
        dfs(image,sr,sc,image[sr][sc],color);
        return image;
    }
    private void dfs(int[][] image, int sr,int sc, int initialColor,int color)
    {
        // base
        if(sr<0 ||sr==n||sc<0 || sc==m || image[sr][sc]!=initialColor) return;
        // logic
        image[sr][sc]=color;
        for(int dir[]:dirs)
        {
            int row=sr+dir[0];
            int col=sc+dir[1];
            dfs(image,row,col,initialColor,color);
        }
    }
}

//Problem 2
// Time Complexity :O(n*m)
// Space Complexity :O(n*m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat==null || mat.length==0) return mat;
        Queue<int[]> q= new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j});
                }
                else{
                    mat[i][j]=-1;
                }
            }
        }
        int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};// U D L R
        int lvl=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int cur[]=q.poll();
                for(int[] dir:dirs)
                {
                    int nr=cur[0]+dir[0];
                    int nc=cur[1]+dir[1];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&& mat[nr][nc]==-1)
                    {
                        mat[nr][nc]=lvl+1;
                        q.add(new int[]{nr,nc});
                    }
                }
                
            }
            lvl++;
        }
       return mat; 
    }
}