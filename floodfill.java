// Time Complexity :O(m*n) m-row length n-column length
// Space Complexity :O(m*n)  
// Did this code successfully run on Leetcode :yes
// Problems Faced: -
//DFS
class Solution {
    int color;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    
        int sp=image[sr][sc];
        color=newColor;
        if(sp==newColor) return image;
                
        return  dfs(image,sr,sc,sp);
    }
    private int[][] dfs(int[][] image, int r,int c,int sp)
    {
        if(r>=0 && r<image.length && c>=0 && c<image[0].length && image[r][c]==sp)
        {
        //logic
        if(sp==image[r][c])
        {
            image[r][c]=color;
            dfs(image,r,c+1,sp);
            dfs(image,r,c-1,sp);
            dfs(image,r+1,c,sp);
            dfs(image,r-1,c,sp);
        }
        }
        return image;
    }
}


// BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<int[]> q=new LinkedList<>();
        int m=image.length;
        int n=image[0].length;
        q.add(new int[]{sr,sc});
        int sp=image[sr][sc];
        
        if(sp==newColor) return image;

        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty())
        {

            int[] temp=q.poll();
            image[temp[0]][temp[1]]=newColor;

            for(int[] dir:dirs)
            {  
                int r=temp[0]+dir[0];
                int c=temp[1]+dir[1];

                if(r>=0 && r<m && c>=0 && c<n && image[r][c]==sp)
                {
                    q.add(new int[]{r,c});
                    image[r][c]=newColor;

                }


            }
        
            
        }
        
        return image;
    }
}