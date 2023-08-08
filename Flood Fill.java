// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
//BFS: We will start from the first element and move to all the four directions to look for the same color in that cell. 
//If we find that color, we will change its color to the one given to us. 
//This way we will change all the colors connected to the first color.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        if(image==null || image.length==0) return image;
        int m=image.length; //rows
        int n=image[0].length; //columns

        if(image[sr][sc]==newColor) return image;

        //directions array
        int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

        // old color is the one already present in the cell
        int oldColor=image[sr][sc];

        //Queue to store the values of columns and rows
        Queue<Integer> q=new LinkedList<>();
        image[sr][sc]=newColor;
        q.add(sr);
        q.add(sc);

        while(!q.isEmpty())
        {
            int CurrR=q.poll(); //Current Row
            int CurrC=q.poll(); // Current Column

            for(int[]dir:dirs)
            {
                int nr=CurrR+dir[0]; //neighboring row
                int nc=CurrC+dir[1]; //neighboring column

                //bounds check
                if(nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==oldColor)
                {
                    image[nr][nc]=newColor;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }

        return image;
    }
}

//DFS

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        if(image==null || image.length==0) return image;
        int m=image.length; //rows
        int n=image[0].length; //columns

        if(image[sr][sc]==newColor) return image;

        //directions array
        int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

        // old color is the one already present in the cell
        int oldColor=image[sr][sc];
        
        dfs(image, sr, sc, oldColor, newColor, m, n, dirs);
        return image;
    }

    private void dfs(int[][] image, int r, int c,int oldColor, int newColor,int m,int n, int[][]dirs)
    {
        //base
        if(r<0 || c<0 || r==m || c==n || image[r][c]!=oldColor)
        return;

        //logic
        //add the new color to the current cell
        image[r][c]=newColor;
        for(int[] dir: dirs)
        {
            int nr=r+dir[0];
            int nc=c+dir[1];
            dfs(image,nr,nc,oldColor,newColor,m,n,dirs); 

        }
           
    }
}